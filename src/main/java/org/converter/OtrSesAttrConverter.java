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

public final class OtrSesAttrConverter {

    public static final String TYPE_NAME = "MFB.OTR_SES_ATTR";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;

    private OtrSesAttrConverter() {
    }

    public static Struct getStruct(OtrSesAttr o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, o.getAttrname()); // ATTRNAME
	    struct.add(1, o.getAttrvalue()); // ATTRVALUE
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrSesAttr> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrSesAttr e : o) {
	        array.add(OtrSesAttrConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrSesAttr getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrSesAttr result = new OtrSesAttr();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setAttrname((String)attr[0]); // ATTRNAME
	    }
	    if (attr[1] != null) {
	        result.setAttrvalue((String)attr[1]); // ATTRVALUE
	    }
	    return result;
	}

    public static List<OtrSesAttr> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrSesAttr> result = new ArrayList<OtrSesAttr>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrSesAttrConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
