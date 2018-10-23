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

public final class OtrTabConverter {

    public static final String TYPE_NAME = "MFB.OTR_TAB";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;

    private OtrTabConverter() {
    }

    public static Struct getStruct(OtrTab o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, OtrRecConverter.getListArray(o.getRecs(), connection, "MFB.OTT_REC")); // RECS
	    struct.add(1, o.getMultivalue()); // MULTIVALUE
	    struct.add(2, o.getParent()); // PARENT
	    struct.add(3, o.getId()); // ID
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrTab> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrTab e : o) {
	        array.add(OtrTabConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrTab getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrTab result = new OtrTab();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setRecs(OtrRecConverter.getObjectList((Array)attr[0])); // RECS
	    }
	    if (attr[1] != null) {
	        result.setMultivalue((String)attr[1]); // MULTIVALUE
	    }
	    if (attr[2] != null) {
	        result.setParent((BigDecimal)attr[2]); // PARENT
	    }
	    if (attr[3] != null) {
	        result.setId((String)attr[3]); // ID
	    }
	    return result;
	}

    public static List<OtrTab> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrTab> result = new ArrayList<OtrTab>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrTabConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
