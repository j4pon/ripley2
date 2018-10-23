package org.converter;

import org.objects.*;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import java.sql.Array;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public final class OtrRecConverter {

    public static final String TYPE_NAME = "MFB.OTR_REC";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;

    private OtrRecConverter() {
    }

    public static Struct getStruct(OtrRec o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, OtrFieldConverter.getListArray(o.getFields(), connection, "MFB.OTT_FIELD")); // FIELDS
	    struct.add(1, o.getRecstatus()); // RECSTATUS
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrRec> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrRec e : o) {
	        array.add(OtrRecConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrRec getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrRec result = new OtrRec();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setFields(OtrFieldConverter.getObjectList((Array)attr[0])); // FIELDS
	    }
	    if (attr[1] != null) {
	        result.setRecstatus((String)attr[1]); // RECSTATUS
	    }
	    return result;
	}

    public static List<OtrRec> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrRec> result = new ArrayList<OtrRec>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrRecConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
