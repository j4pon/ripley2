package org.converter;

import org.objects.*;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import java.sql.Array;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public final class OtrFmConverter {

    public static final String TYPE_NAME = "MFB.OTR_FM";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;
    

    private OtrFmConverter() {
    }

    public static Struct getStruct(OtrFm o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, OtrFmHeaderConverter.getStruct(o.getHeader(), connection)); // HEADER
	    struct.add(1, OtrSesAttrConverter.getListArray(o.getAttrlist(), connection, "MFB.OTT_SES_ATTR")); // ATTRLIST
	    struct.add(2, OtrFtmConverter.getListArray(o.getFtms(), connection, "MFB.OTT_FTM")); // FTMS
	    struct.add(3, o.getMainftm()); // MAINFTM
	    struct.add(4, o.getMainbtid()); // MAINBTID
	    struct.add(5, o.getResponse()); // RESPONSE
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrFm> o, Connection c, String typeName) throws SQLException {
	    OracleConnection connection = c.unwrap(OracleConnection.class);
	    
	    ad = new ArrayDescriptor(typeName, c);
	    
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrFm e : o) {
	        array.add(OtrFmConverter.getStruct(e, connection));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrFm getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrFm result = new OtrFm();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setHeader(OtrFmHeaderConverter.getObject((Struct)attr[0])); // HEADER
	    }
	    if (attr[1] != null) {
	        result.setAttrlist(OtrSesAttrConverter.getObjectList((Array)attr[1])); // ATTRLIST
	    }
	    if (attr[2] != null) {
	        result.setFtms(OtrFtmConverter.getObjectList((Array)attr[2])); // FTMS
	    }
	    if (attr[3] != null) {
	        result.setMainftm((BigDecimal)attr[3]); // MAINFTM
	    }
	    if (attr[4] != null) {
	        result.setMainbtid((String)attr[4]); // MAINBTID
	    }
	    if (attr[5] != null) {
	        result.setResponse((BigDecimal)attr[5]); // RESPONSE
	    }
	    return result;
	}

    public static List<OtrFm> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrFm> result = new ArrayList<OtrFm>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrFmConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
