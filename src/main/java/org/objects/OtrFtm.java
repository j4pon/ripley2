package org.objects;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OtrFtm {

    private List<OtrTab> tabs;
    private String fisaObjectId;
    private String id;
    private String datakey;
    private List<OtrUserMsg> messagelist;
    
    @JsonProperty("tabs")
    public List<OtrTab> getTabs() {
        return this.tabs;
    }
    @JsonProperty("tabs")
    public void setTabs(List<OtrTab> tabs) {
        this.tabs = tabs;
    }
    @JsonProperty("fisa_object_id")
    public String getFisaObjectId() {
        return this.fisaObjectId;
    }
    @JsonProperty("fisa_object_id")
    public void setFisaObjectId(String fisaObjectId) {
        this.fisaObjectId = fisaObjectId;
    }
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("datakey")
    public String getDatakey() {
        return this.datakey;
    }
    @JsonProperty("datakey")
    public void setDatakey(String datakey) {
        this.datakey = datakey;
    }

    public List<OtrUserMsg> getMessagelist() {
        return this.messagelist;
    }

    public void setMessagelist(List<OtrUserMsg> messagelist) {
        this.messagelist = messagelist;
    }


}
