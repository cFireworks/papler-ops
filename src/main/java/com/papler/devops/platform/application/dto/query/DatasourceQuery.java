package com.papler.devops.platform.application.dto.query;

import io.vertx.codegen.annotations.DataObject;


@DataObject
public class DatasourceQuery {

    private String type;

    private String instanceName;

    private String queryStatement;
}
