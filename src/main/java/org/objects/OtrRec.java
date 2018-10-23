package org.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OtrRec {

    private List<OtrField> fields;
    private String recstatus;

    @JsonProperty("fields")
    public List<OtrField> getFields() {
        return this.fields;
    }
    @JsonProperty("fields")
    public void setFields(List<OtrField> fields) {
        this.fields = fields;
    }
    @JsonProperty("recstatus")
    public String getRecstatus() {
        return this.recstatus;
    }
    @JsonProperty("recstatus")
    public void setRecstatus(String recstatus) {
        this.recstatus = recstatus;
    }


}
