package org.model;


import java.sql.SQLData;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Field implements SQLData{
    private String newval;
    private String oldval;
    private String datatype;
    private String id;

    @JsonProperty("newval")
    public String getNewval() { return newval; }
    @JsonProperty("newval")
    public void setNewval(String value) { this.newval = value; }

    @JsonProperty("oldval")
    public String getOldval() { return oldval; }
    @JsonProperty("oldval")
    public void setOldval(String value) { this.oldval = value; }

    @JsonProperty("datatype")
    public String getDatatype() { return datatype; }
    @JsonProperty("datatype")
    public void setDatatype(String value) { this.datatype = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }
}
