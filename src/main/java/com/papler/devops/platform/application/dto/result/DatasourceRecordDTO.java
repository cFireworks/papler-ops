package com.papler.devops.platform.application.dto.result;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.vertx.codegen.annotations.DataObject;

import java.io.Serializable;
import java.util.List;

@DataObject
@RegisterForReflection
public class DatasourceRecordDTO implements Serializable {

    private static final long serialVersionUID = -2540109612845828694L;

    private String id;

    private String content;

    private List<String> header;

    private List<DatasourceRecordItem> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<DatasourceRecordItem> getRows() {
        return rows;
    }

    public void setRows(List<DatasourceRecordItem> rows) {
        this.rows = rows;
    }
}
