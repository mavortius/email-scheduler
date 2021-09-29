package br.com.alura.resource;

import br.com.alura.entity.EmailScheduling;
import br.com.alura.service.EmailSchedulerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("schedules")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchedulesResource {

  @Inject
  EmailSchedulerService service;

  @GET
  public Response list() {
    return Response.ok(service.list()).build();
  }

  @POST
  public Response create(EmailScheduling scheduling) {
    service.add(scheduling);
    return Response.status(201).build();
  }
}
