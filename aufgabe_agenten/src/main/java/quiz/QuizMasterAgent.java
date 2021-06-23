package quiz;


import java.util.*;

import jadex.bridge.IComponentIdentifier;
import jadex.bridge.IInternalAccess;
import jadex.bridge.ServiceCall;
import jadex.bridge.service.annotation.OnStart;
import jadex.commons.Boolean3;
import jadex.commons.future.*;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentArgument;

/**
 *  The quiz master agent.
 */
@Agent(autoprovide = Boolean3.TRUE)
public class QuizMasterAgent implements IQuizService
{
	/** The agent. */
	@Agent
	protected IInternalAccess agent;
	
	/** The current subscriptions per caller id. */
	protected Map<IComponentIdentifier, SubscriptionIntermediateFuture<QuizEvent>> subscriptions = new HashMap<>();
	
	/** The quiz. */
	protected Quiz quiz;
	
	/** The results per caller id. */
	protected Map<IComponentIdentifier, QuizResults> results = new HashMap<IComponentIdentifier, QuizResults>();
	
	/** The delay between questions. */
	@AgentArgument
	protected long delay = 5000;
	
	/** The current question no. */
	protected int questioncnt = 0;
	
	@OnStart
	public void start()
	{
		quiz = createQuiz();

		while (true) {

			System.out.println("Counter: " + questioncnt);

			if(questioncnt < quiz.getNumberOfQuestions()) {
				Question question = quiz.getQuestion(questioncnt);
				publishQuestion(question, questioncnt);
				questioncnt++;
				agent.waitForDelay(delay).get();
			} else {
				questioncnt = 0;
			}
		}
	}
	
	/**
	 *  Create a quiz.
	 */
	protected Quiz createQuiz() {
		// create a quiz object
		Quiz quiz = new Quiz();

		List<String> answers1 = new ArrayList<>();
		answers1.add("2");
		answers1.add("3");
		answers1.add("4");
		answers1.add("1");

		Question question1 = new Question();
		question1.setQuestion("How much is 1 + 1?");
		question1.setSolution(0);
		question1.setAnswers(answers1);

		List<String> answers2 = new ArrayList<>();
		answers2.add("8");
		answers2.add("1");
		answers2.add("2");
		answers2.add("3");

		Question question2 = new Question();
		question2.setQuestion("How much is 4 + 4?");
		question2.setSolution(0);
		question2.setAnswers(answers2);

		List<String> answers3 = new ArrayList<>();
		answers3.add("-12443231");
		answers3.add("-11261292");
		answers3.add("-13841389");
		answers3.add("Hold on. The other questions were way easier!");

		Question question3 = new Question();
		question3.setQuestion("How much is  3^7 * 2 - 3 + 9^2 - 61^4");
		question3.setSolution(2);
		question3.setAnswers(answers3);

		quiz.addQuestion(question1);
		quiz.addQuestion(question2);
		quiz.addQuestion(question3);

		return quiz;
	}
	
	/**
	 *  Publish a question to all subscribers.
	 *  @param question The question.
	 */
	public void publishQuestion(Question question, int questioncnt)
	{
		System.out.println("Publish Question!");

		// send question to all subscribers
		QuestionEvent event = new QuestionEvent(question, questioncnt);

		System.out.println("Subscriptions: " + subscriptions.entrySet().size());

		for (Map.Entry<IComponentIdentifier, SubscriptionIntermediateFuture<QuizEvent>> entry: subscriptions.entrySet()) {
			System.out.println("Send Question");
			entry.getValue().addIntermediateResult(event);
		}
	}
	
	/**
	 *  Method to participate in the quiz.
	 *  @return The subscription for receiving quiz events.
	 */
	public ISubscriptionIntermediateFuture<QuizEvent> participate()
	{
		// called by clients to join
		// create a subscription future and save it per caller
		// set termination command to remove subscription when terminated

		IComponentIdentifier caller = ServiceCall.getCurrentInvocation().getCaller();

		System.out.println("Caller: " + caller);

		SubscriptionIntermediateFuture<QuizEvent> future = new SubscriptionIntermediateFuture<>();
		TerminationCommand command = new TerminationCommand() {
			@Override
			public void terminated(Exception reason) {
				subscriptions.remove(caller);
			}
		};

		future.setTerminationCommand(command);
		subscriptions.put(caller, future);

		QuestionEvent event = new QuestionEvent();
		event.setQuestion(quiz.getQuestion(questioncnt));

		future.addIntermediateResult(event);

		return future;
	}

	/**
	 *  Send an answer.
	 *  @param answer The answer.
	 */
	public IFuture<Void> processAnswer(int answer, int questioncnt)
	{
		System.out.println("####");

		QuizResults quizResults;

		Question question = quiz.getQuestion(questioncnt);

		IComponentIdentifier caller = ServiceCall.getCurrentInvocation().getCaller();

		System.out.println(caller);

		if (caller != null) {
			if (!results.containsKey(caller)) {

				quizResults = new QuizResults();
				results.put(caller, quizResults);

			} else {
				quizResults = results.get(caller);
			}

			if(quizResults.results.isEmpty()) {

				System.out.println("Is empty --> A D D");

				quizResults.addResult(questioncnt, answer == question.solution);
			} else {
				for(QuizResults.Result result: results.get(caller).results) {
					if(questioncnt == result.getNo()) {
						System.out.println("Question is already answered!");
					} else {
						System.out.println("Added Question!: Counter: " + questioncnt + "  " + result.getNo());

						quizResults.addResult(questioncnt, answer == question.solution);
						break;
					}
				}
			}

			System.out.println("Current Result Count: " + quizResults.results.size());

			System.out.println("Questions In Quiz: " + quiz.questions.size());

			System.out.println("####\n");

			if(quizResults.results.size() == quiz.questions.size()) {

				subscriptions.get(caller).addIntermediateResult(new ResultEvent(quizResults));
				subscriptions.remove(caller);
			}
		}



		return IFuture.DONE;
	}
}
