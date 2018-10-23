package org.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrField {

    private String newval;
    private String oldval;
    private String datatype;
    private String id;
    
    @JsonProperty("newval")
    public String getNewval() {
        return this.newval;
    }
    @JsonProperty("newval")
    public void setNewval(String newval) {
        this.newval = newval;
    }
    @JsonProperty("oldval")
    public String getOldval() {
        return this.oldval;
    }
    @JsonProperty("oldval")
    public void setOldval(String oldval) {
        this.oldval = oldval;
    }
    @JsonProperty("datatype")
    public String getDatatype() {
        return this.datatype;
    }
    @JsonProperty("datatype")
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }


}
