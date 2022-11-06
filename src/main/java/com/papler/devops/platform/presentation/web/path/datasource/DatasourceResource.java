package com.papler.devops.platform.presentation.web.path.datasource;


import com.papler.devops.platform.application.dto.query.DatasourceQuery;
import com.papler.devops.platform.application.dto.result.DatasourceRecordDTO;
import com.papler.devops.platform.application.dto.result.DatasourceRecordItem;
import com.papler.devops.platform.infrastructure.datasource.mysql.DatabaseBoundary;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Consumes
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/datasource")
public class DatasourceResource {

    @Inject
    DatabaseBoundary databaseBoundary;

    @POST
    @Path("/query")
    public Uni<Response> query(DatasourceQuery param) {
        DatasourceRecordDTO result = new DatasourceRecordDTO();
        result.setId("888");
        List<String> header = Arrays.asList("id", "name", "age");
        DatasourceRecordItem item = new DatasourceRecordItem();
        item.setKey("888");
        item.setValueList(Arrays.asList("123", "wkx", "26"));
        result.setHeader(header);
        result.setRows(List.of(item));

        result.setContent("ok");
        return Uni.createFrom().item(Response.ok(result).build());
    }

    @POST
    @Path("/ops/hello")
    public String hello(DatasourceQuery param) {
        return "hello, papler ops!";
    }
}
