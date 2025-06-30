package com.trepudox.bff.infra.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingController {

    @GET
    @Path("/again")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.status(200).entity("{\"message\": \"Hello World!\"}").build();
    }
}
