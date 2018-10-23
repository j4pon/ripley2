package org.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OtrFm {

    private OtrFmHeader header;
    private List<OtrSesAttr> attrlist;
    private List<OtrFtm> ftms;
    private BigDecimal mainftm;
    private String mainbtid;
    private BigDecimal response;

    @JsonProperty("header")
    public OtrFmHeader getHeader() {
        return this.header;
    }
    @JsonProperty("header")
    public void setHeader(OtrFmHeader header) {
        this.header = header;
    }

    public List<OtrSesAttr> getAttrlist() {
        return this.attrlist;
    }

    public void setAttrlist(List<OtrSesAttr> attrlist) {
        this.attrlist = attrlist;
    }
    @JsonProperty("ftms")
    public List<OtrFtm> getFtms() {
        return this.ftms;
    }
    @JsonProperty("ftms")
    public void setFtms(List<OtrFtm> ftms) {
        this.ftms = ftms;
    }
    @JsonProperty("mainftm")
    public BigDecimal getMainftm() {
        return this.mainftm;
    }
    @JsonProperty("mainftm")
    public void setMainftm(BigDecimal mainftm) {
        this.mainftm = mainftm;
    }
    @JsonProperty("mainbtid")
    public String getMainbtid() {
        return this.mainbtid;
    }
    @JsonProperty("mainbtid")
    public void setMainbtid(String mainbtid) {
        this.mainbtid = mainbtid;
    }
    @JsonProperty("response")
    public BigDecimal getResponse() {
        return this.response;
    }
    @JsonProperty("response")
    public void setResponse(BigDecimal response) {
        this.response = response;
    }


}
