package rest;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class App extends ResourceConfig
{
    public App() 
    {
    	System.out.println("deployed app");
        packages("rest");
    }
}