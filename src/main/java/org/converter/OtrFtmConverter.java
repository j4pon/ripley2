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

public final class OtrFtmConverter {

    public static final String TYPE_NAME = "MFB.OTR_FTM";
    public static StructDescriptor sd;
    public static ArrayDescriptor ad;

    private OtrFtmConverter() {
    }

    public static Struct getStruct(OtrFtm o, Connection connection) throws SQLException {
	    if (o == null) {
	        return null;
	    }
	    
	    sd = StructDescriptor.createDescriptor(TYPE_NAME, connection);
	    
	    List<Object> struct = new ArrayList<Object>();
	    struct.add(0, OtrTabConverter.getListArray(o.getTabs(), connection, "MFB.OTT_TAB")); // TABS
	    struct.add(1, o.getFisaObjectId()); // FISA_OBJECT_ID
	    struct.add(2, o.getId()); // ID
	    struct.add(3, o.getDatakey()); // DATAKEY
	    struct.add(4, OtrUserMsgConverter.getListArray(o.getMessagelist(), connection, "MFB.OTT_USER_MSG")); // MESSAGELIST
	    //return connection.createStruct(TYPE_NAME, struct.toArray());
	    return new STRUCT(sd, connection, struct.toArray());
	}

    public static Array getListArray(List<OtrFtm> o, Connection c, String typeName) throws SQLException {
	    //OracleConnection connection = c.unwrap(OracleConnection.class);
	    ad = new ArrayDescriptor(typeName, c);
	    if (o == null) {
	        //return connection.createArrayOf(typeName, new Object[0]);
	    	return new ARRAY(ad, c, new Object[0]);
	    }
	    List<Object> array = new ArrayList<Object>(o.size());
	    for (OtrFtm e : o) {
	        array.add(OtrFtmConverter.getStruct(e, c));
	    }
	    //return connection.createArrayOf(typeName, array.toArray());
	    return new ARRAY(ad, c, array.toArray());
	}

    public static OtrFtm getObject(Struct struct) throws SQLException {
	    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
	        return null;
	    }
	    OtrFtm result = new OtrFtm();
	    Object[] attr = struct.getAttributes();
	    if (attr[0] != null) {
	        result.setTabs(OtrTabConverter.getObjectList((Array)attr[0])); // TABS
	    }
	    if (attr[1] != null) {
	        result.setFisaObjectId((String)attr[1]); // FISA_OBJECT_ID
	    }
	    if (attr[2] != null) {
	        result.setId((String)attr[2]); // ID
	    }
	    if (attr[3] != null) {
	        result.setDatakey((String)attr[3]); // DATAKEY
	    }
	    if (attr[4] != null) {
	        result.setMessagelist(OtrUserMsgConverter.getObjectList((Array)attr[4])); // MESSAGELIST
	    }
	    return result;
	}

    public static List<OtrFtm> getObjectList(Array array) throws SQLException {
	    if (array == null) {
	        return null;
	    }
	    List<OtrFtm> result = new ArrayList<OtrFtm>();
	    ResultSet rs = null;
	    try {
	        rs = array.getResultSet();
	        while (rs.next()) {
	            result.add(OtrFtmConverter.getObject((Struct) rs.getObject(2)));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	    }
	    return result;
	}

}
