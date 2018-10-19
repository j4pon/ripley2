package org.model;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Header {
    private String userid;
    private String languageid;
    private String branchid;
    private String officeid;
    private String deptoid;
    private String terminalid;
    private String messengerid;
    private String sessionkey;
    private String externalreference;
    private String referenceuser;
    private String processtype;

    @JsonProperty("userid")
    public String getUserid() { return userid; }
    @JsonProperty("userid")
    public void setUserid(String value) { this.userid = value; }

    @JsonProperty("languageid")
    public String getLanguageid() { return languageid; }
    @JsonProperty("languageid")
    public void setLanguageid(String value) { this.languageid = value; }

    @JsonProperty("branchid")
    public String getBranchid() { return branchid; }
    @JsonProperty("branchid")
    public void setBranchid(String value) { this.branchid = value; }

    @JsonProperty("officeid")
    public String getOfficeid() { return officeid; }
    @JsonProperty("officeid")
    public void setOfficeid(String value) { this.officeid = value; }

    @JsonProperty("deptoid")
    public String getDeptoid() { return deptoid; }
    @JsonProperty("deptoid")
    public void setDeptoid(String value) { this.deptoid = value; }

    @JsonProperty("terminalid")
    public String getTerminalid() { return terminalid; }
    @JsonProperty("terminalid")
    public void setTerminalid(String value) { this.terminalid = value; }

    @JsonProperty("messengerid")
    public String getMessengerid() { return messengerid; }
    @JsonProperty("messengerid")
    public void setMessengerid(String value) { this.messengerid = value; }

    @JsonProperty("sessionkey")
    public String getSessionkey() { return sessionkey; }
    @JsonProperty("sessionkey")
    public void setSessionkey(String value) { this.sessionkey = value; }

    @JsonProperty("externalreference")
    public String getExternalreference() { return externalreference; }
    @JsonProperty("externalreference")
    public void setExternalreference(String value) { this.externalreference = value; }

    @JsonProperty("referenceuser")
    public String getReferenceuser() { return referenceuser; }
    @JsonProperty("referenceuser")
    public void setReferenceuser(String value) { this.referenceuser = value; }

    @JsonProperty("processtype")
    public String getProcesstype() { return processtype; }
    @JsonProperty("processtype")
    public void setProcesstype(String value) { this.processtype = value; }
}
