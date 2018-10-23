package org.objects;


import java.math.BigDecimal;

public class OtrFmHeader {

    private String userid;
    private String languageid;
    private BigDecimal branchid;
    private BigDecimal officeid;
    private BigDecimal deptoid;
    private String terminalid;
    private String messengerid;
    private String sessionkey;
    private String externalreference;
    private String referenceuser;
    private String processtype;

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLanguageid() {
        return this.languageid;
    }

    public void setLanguageid(String languageid) {
        this.languageid = languageid;
    }

    public BigDecimal getBranchid() {
        return this.branchid;
    }

    public void setBranchid(BigDecimal branchid) {
        this.branchid = branchid;
    }

    public BigDecimal getOfficeid() {
        return this.officeid;
    }

    public void setOfficeid(BigDecimal officeid) {
        this.officeid = officeid;
    }

    public BigDecimal getDeptoid() {
        return this.deptoid;
    }

    public void setDeptoid(BigDecimal deptoid) {
        this.deptoid = deptoid;
    }

    public String getTerminalid() {
        return this.terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getMessengerid() {
        return this.messengerid;
    }

    public void setMessengerid(String messengerid) {
        this.messengerid = messengerid;
    }

    public String getSessionkey() {
        return this.sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public String getExternalreference() {
        return this.externalreference;
    }

    public void setExternalreference(String externalreference) {
        this.externalreference = externalreference;
    }

    public String getReferenceuser() {
        return this.referenceuser;
    }

    public void setReferenceuser(String referenceuser) {
        this.referenceuser = referenceuser;
    }

    public String getProcesstype() {
        return this.processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }


}