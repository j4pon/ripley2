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

public final class OtrFieldConverter {

    public static final String TYPE_NAME = "MFB.OTR_FIELD";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;
    
    private OtrFieldConverter() {
    }

    public static Struct getStruct(OtrField o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, o.getNewval()); // NEWVAL
	    struct.add(1, o.getOldval()); // OLDVAL
	    struct.add(2, o.getDatatype()); // DATATYPE
	    struct.add(3, o.getId()); // ID
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrField> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrField e : o) {
	        array.add(OtrFieldConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrField getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrField result = new OtrField();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setNewval((String)attr[0]); // NEWVAL
	    }
	    if (attr[1] != null) {
	        result.setOldval((String)attr[1]); // OLDVAL
	    }
	    if (attr[2] != null) {
	        result.setDatatype((String)attr[2]); // DATATYPE
	    }
	    if (attr[3] != null) {
	        result.setId((String)attr[3]); // ID
	    }
	    return result;
	}

    public static List<OtrField> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrField> result = new ArrayList<OtrField>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrFieldConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
