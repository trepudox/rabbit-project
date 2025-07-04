package com.trepudox.bff.infra.webclient.restclient;

import com.trepudox.bff.infra.webclient.data.response.CargoRestResponse;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

// TODO: Alterar os retornos
@Path("/cargo")
@RegisterRestClient(configKey = "cargo-api")
public interface CargoRestClient {

    @POST
    RestResponse<?> create();

    @GET
    RestResponse<List<CargoRestResponse>> getAll();

    @GET
    @Path("/{id}")
    RestResponse<CargoRestResponse> getById(@RestPath long id);

    @PUT
    RestResponse<?> update();

    @DELETE
    @Path("/{id}")
    RestResponse<?> delete(@RestPath long id);

}
