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

public final class OtrUserMsgConverter {

    public static final String TYPE_NAME = "MFB.OTR_USER_MSG";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;


    private OtrUserMsgConverter() {
    }

    public static Struct getStruct(OtrUserMsg o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, o.getText()); // TEXT
	    struct.add(1, o.getMsgtype()); // MSGTYPE
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrUserMsg> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);	    
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrUserMsg e : o) {
	        array.add(OtrUserMsgConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrUserMsg getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrUserMsg result = new OtrUserMsg();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setText((String)attr[0]); // TEXT
	    }
	    if (attr[1] != null) {
	        result.setMsgtype((String)attr[1]); // MSGTYPE
	    }
	    return result;
	}

    public static List<OtrUserMsg> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrUserMsg> result = new ArrayList<OtrUserMsg>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrUserMsgConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
