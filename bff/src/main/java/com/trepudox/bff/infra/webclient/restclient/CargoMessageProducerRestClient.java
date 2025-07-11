package com.trepudox.bff.infra.webclient.restclient;

import com.trepudox.bff.infra.webclient.data.request.CreateCargoRestClientRequest;
import com.trepudox.bff.infra.webclient.data.request.UpdateCargoRestClientRequest;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

// TODO: Alterar os retornos
@Path("/cargo")
@RegisterRestClient(configKey = "cargo-message-producer-api")
public interface CargoMessageProducerRestClient {

    @POST
    RestResponse<?> create(CreateCargoRestClientRequest createCargoRequest);

    @PUT
    RestResponse<?> update(UpdateCargoRestClientRequest updateCargoRequest);

    @DELETE
    @Path("/{id}")
    RestResponse<?> delete(@RestPath long id);

}
