package org.objects;

import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtrTab {

    private List<OtrRec> recs;
    private String multivalue;
    private BigDecimal parent;
    private String id;

    @JsonProperty("recs")
    public List<OtrRec> getRecs() {
        return this.recs;
    }
    @JsonProperty("recs")
    public void setRecs(List<OtrRec> recs) {
        this.recs = recs;
    }
    @JsonProperty("multivalue")
    public String getMultivalue() {
        return this.multivalue;
    }
    @JsonProperty("multivalue")
    public void setMultivalue(String multivalue) {
        this.multivalue = multivalue;
    }
    @JsonProperty("parent")
    public BigDecimal getParent() {
        return this.parent;
    }
    @JsonProperty("parent")
    public void setParent(BigDecimal parent) {
        this.parent = parent;
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
