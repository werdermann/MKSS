package helloworld;

import jadex.base.PlatformConfigurationHandler;
import jadex.base.Starter;
import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.OnEnd;
import jadex.bridge.service.annotation.OnInit;
import jadex.bridge.service.annotation.OnStart;
import jadex.bridge.service.types.cms.CreationInfo;
import jadex.micro.annotation.Agent;

@Agent
public class HelloWorldAgent
{
    @Agent
    IInternalAccess agent;

    @OnStart
    public void start() {
        System.out.println("Hello agent " + agent.getId());
    }

    @OnInit
    public void init() {
        System.out.println("### Initialize ###");
    }

    @OnEnd
    public void end() {
        System.out.println("### End ###");
    }



    public static void main(String[] args) throws InterruptedException {
        IExternalAccess platform = Starter.createPlatform(PlatformConfigurationHandler.getDefaultNoGui()).get();
        IExternalAccess agent = platform.createComponent(new CreationInfo().setFilenameClass(HelloWorldAgent.class)).get();

        Thread.sleep(1000);

        agent.killComponent();
    }

	// print text in init, start and end methods of agent
	// print additionally the agent id in start
}
