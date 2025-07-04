package com.trepudox.bff.infra.controller;

import com.trepudox.bff.infra.controller.data.request.CreateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.request.UpdateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.response.CargoControllerResponse;
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
    public Response create(CreateCargoControllerRequest createCargoControllerRequest) {
        CargoControllerResponse cargoControllerResponse = cargoService.create(createCargoControllerRequest);
        return Response.status(Response.Status.CREATED).entity(cargoControllerResponse).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CargoControllerResponse> cargoControllerResponseList = cargoService.getAll();
        return Response.ok(cargoControllerResponseList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@RestPath long id) {
        CargoControllerResponse cargoControllerResponse = cargoService.getById(id);
        return Response.ok(cargoControllerResponse).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UpdateCargoControllerRequest updateCargoControllerRequest) {
        CargoControllerResponse cargoControllerResponse = cargoService.update(updateCargoControllerRequest);
        return Response.ok(cargoControllerResponse).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@RestPath Long id) {
        cargoService.deleteById(id);
        return Response.ok().build();
    }
}
