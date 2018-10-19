package org.model;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Ftm {
    private Tab[] tabs;
    private String fisaObjectID;
    private String id;
    private String datakey;

    @JsonProperty("tabs")
    public Tab[] getTabs() { return tabs; }
    @JsonProperty("tabs")
    public void setTabs(Tab[] value) { this.tabs = value; }

    @JsonProperty("fisa_object_id")
    public String getFisaObjectID() { return fisaObjectID; }
    @JsonProperty("fisa_object_id")
    public void setFisaObjectID(String value) { this.fisaObjectID = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("datakey")
    public String getDatakey() { return datakey; }
    @JsonProperty("datakey")
    public void setDatakey(String value) { this.datakey = value; }
}
