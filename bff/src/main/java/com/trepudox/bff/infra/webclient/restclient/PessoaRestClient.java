package com.trepudox.bff.infra.webclient.restclient;

import com.trepudox.bff.infra.webclient.PessoaWebClient;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;
import java.util.Optional;

// TODO: Alterar os retornos
@Path("/pessoa")
@RegisterRestClient
public interface PessoaRestClient extends PessoaWebClient {

    @POST
    RestResponse<?> create();

    @GET
    RestResponse<List<?>> getAll();

    @GET
    @Path("/{id}")
    RestResponse<Optional<?>> getById(@RestPath long id);

    @PUT
    RestResponse<?> update();

    @DELETE
    @Path("/{id}")
    RestResponse<?> delete(@RestPath long id);

}
