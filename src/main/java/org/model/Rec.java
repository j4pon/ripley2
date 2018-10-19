package org.model;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Rec {
    private String recstatus;
    private Field[] fields;

    @JsonProperty("recstatus")
    public String getRecstatus() { return recstatus; }
    @JsonProperty("recstatus")
    public void setRecstatus(String value) { this.recstatus = value; }

    @JsonProperty("fields")
    public Field[] getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(Field[] value) { this.fields = value; }
}
