package com.example.helloworld;

import com.example.helloworld.resources.HelloWorldResources;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by nasir on 18/4/15.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName(){
        return "Hello World";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){

    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {

        final HelloWorldResources resources = new HelloWorldResources(
                helloWorldConfiguration.getTemplate(),
                helloWorldConfiguration.getDefaultName(),
                helloWorldConfiguration.getCounter());

        environment.jersey().register(resources);
    }
}
