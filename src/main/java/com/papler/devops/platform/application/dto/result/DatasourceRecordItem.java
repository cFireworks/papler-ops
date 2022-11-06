package com.papler.devops.platform.application.dto.result;

import io.vertx.codegen.annotations.DataObject;

import java.io.Serializable;
import java.util.List;

@DataObject
public class DatasourceRecordItem implements Serializable {

    private static final long serialVersionUID = 322736906239118354L;

    private String key;

    private List<String> valueList;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
}
