package quiz;

import java.util.HashMap;
import java.util.Map;

import jadex.bridge.IComponentIdentifier;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.OnStart;
import jadex.commons.Boolean3;
import jadex.commons.future.IFuture;
import jadex.commons.future.ISubscriptionIntermediateFuture;
import jadex.commons.future.SubscriptionIntermediateFuture;
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
		// fetch next question from quiz (start from first when max)
		// send it to the subscribers
		// wait some time 
	}
	
	/**
	 *  Create a quiz.
	 */
	protected Quiz createQuiz()
	{
		// create a quiz object
		return null;
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
	
		// todo: return future
		return null;
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
