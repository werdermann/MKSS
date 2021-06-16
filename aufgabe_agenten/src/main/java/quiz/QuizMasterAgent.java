package quiz;

import java.awt.desktop.QuitEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import jadex.bridge.ComponentIdentifier;
import jadex.bridge.IComponentIdentifier;
import jadex.bridge.IInternalAccess;
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
		while (true) {
			Question currentQuestion = quiz.questions.get(questioncnt);

			if(questioncnt < quiz.questions.size()) {
				questioncnt++;
			} else {
				questioncnt = 0;
			}

			for (Map.Entry<IComponentIdentifier, SubscriptionIntermediateFuture<QuizEvent>> entry: subscriptions.entrySet()) {

				entry.getValue().addIntermediateResult(currentQuestion);

				//entry.getKey().
			}
		}






		// fetch next question from quiz (start from first when max)
		// send it to the subscribers








		// wait some time 
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
		question3.setSolution(3);
		question3.setAnswers(answers3);

		return quiz;
	}
	
	/**
	 *  Publish a question to all subscribers.
	 *  @param question The question.
	 */
	public void publishQuestion(Question question, int questioncnt)
	{
		// send question to all subscribers
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

		ComponentIdentifier identifier = new ComponentIdentifier();
		SubscriptionIntermediateFuture<QuizEvent> future = new SubscriptionIntermediateFuture<>();
		TerminationCommand command = new TerminationCommand() {
			@Override
			public void terminated(Exception reason) {
				subscriptions.remove(identifier);
			}
		};
		future.setTerminationCommand(command);
		subscriptions.put(identifier, future);

		return future;
	}

	/**
	 *  Send an answer.
	 *  @param answer The answer.
	 */
	public IFuture<Void> processAnswer(int answer, int questioncnt)
	{
		// create QuizResults if caller has none
		// add new result to its QuizResults
		// check if all questions have been played 
		// if yes: send result event to client, set subscription to finished and remove it
	
		return IFuture.DONE;
	}
}
