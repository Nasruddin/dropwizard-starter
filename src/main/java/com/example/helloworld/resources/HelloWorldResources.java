package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.core.Saying;
import com.example.helloworld.resources.response.ResponsePro;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nasir on 18/4/15.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResources {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResources(String template, String defaultName, AtomicLong counter) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = counter;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {

        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Path("/hello")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHelloAgain(){
        System.out.println("In hello world");

        ResponsePro responsePro = new ResponsePro();

        responsePro.setName("Name");
        responsePro.setNickName("Nasir");

        return Response.status(Response.Status.OK).entity(responsePro).build();
    }
}
