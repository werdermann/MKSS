package counter;

import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.OnStart;
import jadex.micro.annotation.Agent;

@Agent
public class CounterAgent
{
	@Agent
	protected IInternalAccess agent;
	
	@OnStart
	public void body()
	{
		// count from 0 to 9 and wait one second after each print out
	}
}
