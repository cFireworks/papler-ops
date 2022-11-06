package com.papler.devops.platform.presentation.web.path;

import com.papler.devops.platform.domain.MyEntity;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Consumes
@Produces
@Path("/hello")
public class ExampleResource {

    @GET
    @Path("/reactive")
    public Uni<List<MyEntity>> get() {
        return MyEntity.listAll();
    }

    @POST
    @Path("create")
    @ReactiveTransactional
    public Uni<Response> create(MyEntity entity) {

        return entity.<MyEntity>persist()
                .onItem()
                .transform(inserted -> Response.created(URI.create("/MyEntity/" + inserted.id)).build());
    }
}