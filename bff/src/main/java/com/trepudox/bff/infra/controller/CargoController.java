package com.trepudox.bff.infra.controller;

import com.trepudox.bff.core.data.request.CreateCargoRequest;
import com.trepudox.bff.core.data.request.UpdateCargoRequest;
import com.trepudox.bff.core.data.response.CargoResponse;
import com.trepudox.bff.core.service.CargoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Path("/cargo")
public class CargoController {

    private final CargoService cargoService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CreateCargoRequest createCargoRequest) {
        CargoResponse cargoResponse = cargoService.create(createCargoRequest);
        return Response.status(Response.Status.CREATED).entity(cargoResponse).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CargoResponse> cargoResponseList = cargoService.getAll();
        return Response.ok(cargoResponseList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@RestPath long id) {
        CargoResponse cargoResponse = cargoService.getById(id);
        return Response.ok(cargoResponse).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UpdateCargoRequest updateCargoRequest) {
        CargoResponse cargoResponse = cargoService.update(updateCargoRequest);
        return Response.ok(cargoResponse).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@RestPath Long id) {
        cargoService.deleteById(id);
        return Response.ok().build();
    }
}
