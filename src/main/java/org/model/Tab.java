package org.model;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Tab {
    private String multivalue;
    private String parent;
    private String id;
    private Rec[] recs;

    @JsonProperty("multivalue")
    public String getMultivalue() { return multivalue; }
    @JsonProperty("multivalue")
    public void setMultivalue(String value) { this.multivalue = value; }

    @JsonProperty("parent")
    public String getParent() { return parent; }
    @JsonProperty("parent")
    public void setParent(String value) { this.parent = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("recs")
    public Rec[] getRecs() { return recs; }
    @JsonProperty("recs")
    public void setRecs(Rec[] value) { this.recs = value; }
}
