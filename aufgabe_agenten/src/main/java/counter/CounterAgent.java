package counter;

import helloworld.HelloWorldAgent;
import jadex.base.PlatformConfigurationHandler;
import jadex.base.Starter;
import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.OnStart;
import jadex.bridge.service.types.cms.CreationInfo;
import jadex.micro.annotation.Agent;

@Agent
public class CounterAgent
{
	@Agent
	protected IInternalAccess agent;

	@OnStart
	public void body() {
		// count from 0 to 9 and wait one second after each print out
		for(int i = 0; i < 10; i++) {
			agent.waitForDelay(1000).get();
			System.out.println("Agent " + agent.getId() + " " + i);
		}

		agent.killComponent();
	}

	public static void main(String[] args) {
		IExternalAccess platform = Starter.createPlatform(PlatformConfigurationHandler.getDefaultNoGui()).get();
		platform.createComponent(new CreationInfo().setFilenameClass(CounterAgent.class)).get();
	}
}
