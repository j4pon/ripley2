package org.model;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Fm {
    private Header header;
    private Ftm[] ftms;
    private String mainftm;
    private String mainbtid;
    private String response;

    @JsonProperty("header")
    public Header getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(Header value) { this.header = value; }

    @JsonProperty("ftms")
    public Ftm[] getFtms() { return ftms; }
    @JsonProperty("ftms")
    public void setFtms(Ftm[] value) { this.ftms = value; }

    @JsonProperty("mainftm")
    public String getMainftm() { return mainftm; }
    @JsonProperty("mainftm")
    public void setMainftm(String value) { this.mainftm = value; }

    @JsonProperty("mainbtid")
    public String getMainbtid() { return mainbtid; }
    @JsonProperty("mainbtid")
    public void setMainbtid(String value) { this.mainbtid = value; }

    @JsonProperty("response")
    public String getResponse() { return response; }
    @JsonProperty("response")
    public void setResponse(String value) { this.response = value; }
}
