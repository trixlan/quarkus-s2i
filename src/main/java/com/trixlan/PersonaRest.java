package com.trixlan;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.enterprise.context.ApplicationScoped;

@Path("/persons")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaRest {

    @GET
    public List<Persona> list() {
        return Persona.listAll();
    }

    @GET
    @Path("/{id}")
    public Persona get(Long id) {
        return Persona.findById(id);
    }

    @POST 
    @Transactional
    public Response create(Persona persona) {
        persona.persist();
        return Response.ok(persona).status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Persona update(Long id, Persona persona) {
        Persona entity = Persona.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the persona parameter to the existing entity
        entity.nombre = persona.nombre;
        entity.apellido = persona.apellido;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Persona entity = Persona.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @GET
    @Path("/count")
    public Long count() {
        return Persona.count();
    }
}