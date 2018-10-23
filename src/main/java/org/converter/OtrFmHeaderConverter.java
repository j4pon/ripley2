package org.converter;

import org.objects.*;
import oracle.jdbc.OracleConnection;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import java.sql.Array;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class OtrFmHeaderConverter {

    public static final String TYPE_NAME = "MFB.OTR_FM_HEADER";
    public static StructDescriptor sd;

    private OtrFmHeaderConverter() {
    }

    public static Struct getStruct(OtrFmHeader o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, o.getUserid()); // USERID
	    struct.add(1, o.getLanguageid()); // LANGUAGEID
	    struct.add(2, o.getBranchid()); // BRANCHID
	    struct.add(3, o.getOfficeid()); // OFFICEID
	    struct.add(4, o.getDeptoid()); // DEPTOID
	    struct.add(5, o.getTerminalid()); // TERMINALID
	    struct.add(6, o.getMessengerid()); // MESSENGERID
	    struct.add(7, o.getSessionkey()); // SESSIONKEY
	    struct.add(8, o.getExternalreference()); // EXTERNALREFERENCE
	    struct.add(9, o.getReferenceuser()); // REFERENCEUSER
	    struct.add(10, o.getProcesstype()); // PROCESSTYPE
	    
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
    
    }

    public static Array getListArray(List<OtrFmHeader> o, Connection c, String typeName) throws SQLException {
	    OracleConnection connection = c.unwrap(OracleConnection.class);
	    if (o == null) {
	        return connection.createArrayOf(typeName, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrFmHeader e : o) {
	        array.add(OtrFmHeaderConverter.getStruct(e, connection));
	    }
	    return connection.createArrayOf(typeName, array.toArray());
	}

    public static OtrFmHeader getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrFmHeader result = new OtrFmHeader();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setUserid((String)attr[0]); // USERID
	    }
	    if (attr[1] != null) {
	        result.setLanguageid((String)attr[1]); // LANGUAGEID
	    }
	    if (attr[2] != null) {
	        result.setBranchid((BigDecimal)attr[2]); // BRANCHID
	    }
	    if (attr[3] != null) {
	        result.setOfficeid((BigDecimal)attr[3]); // OFFICEID
	    }
	    if (attr[4] != null) {
	        result.setDeptoid((BigDecimal)attr[4]); // DEPTOID
	    }
	    if (attr[5] != null) {
	        result.setTerminalid((String)attr[5]); // TERMINALID
	    }
	    if (attr[6] != null) {
	        result.setMessengerid((String)attr[6]); // MESSENGERID
	    }
	    if (attr[7] != null) {
	        result.setSessionkey((String)attr[7]); // SESSIONKEY
	    }
	    if (attr[8] != null) {
	        result.setExternalreference((String)attr[8]); // EXTERNALREFERENCE
	    }
	    if (attr[9] != null) {
	        result.setReferenceuser((String)attr[9]); // REFERENCEUSER
	    }
	    if (attr[10] != null) {
	        result.setProcesstype((String)attr[10]); // PROCESSTYPE
	    }
	    return result;
	}

    public static List<OtrFmHeader> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrFmHeader> result = new ArrayList<OtrFmHeader>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrFmHeaderConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
