package com.trepudox.bff.infra.webclient.restclient;

import com.trepudox.bff.infra.webclient.data.response.CargoRestClientResponse;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/cargo")
@RegisterRestClient(configKey = "cargo-api")
public interface CargoRestClient {

    @GET
    RestResponse<List<CargoRestClientResponse>> getAll();

    @GET
    @Path("/{id}")
    RestResponse<CargoRestClientResponse> getById(@RestPath long id);

}
