package org.test;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.context.PkgChrChargesCallProRun2;
import org.context.PkgChrChargesCallProTest;
import org.converter.OtrFmConverter;
import org.converter.OtrFmHeaderConverter;
import org.model.Converter;
import org.model.Fm;
import org.objects.OtrFm;
import org.objects.OtrFmHeader;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class test {
	public static void main(String[] args) throws Exception {

		/*---------------------------------------------------------------------*/
		HashMap<String, Elementos> x = CreaCtaD.Layout().getLayout();

		Object[] join = new Object[4];

		String json = "{";
		json += "\"newval\":\"\",";
		json += "\"oldval\":\"\",";
		json += "\"datatype\":<<t>>,";
		json += "\"id\":\"<<k>>\"";
		json += "}";
		for (int i = 0; i < join.length; i++) {
			ArrayList<String> values = new ArrayList<String>();
			for (Entry<String, Elementos> entry : x.entrySet()) {
				if (entry.getValue().getIsArray()) {
					if (entry.getValue().getIndiceArray() == i) {
						String j = json;
						j = j.replace("<<t>>", "\"<<" + entry.getKey() + ">>\"");
						j = j.replace("<<k>>", entry.getKey().split("\\.")[1]);
						values.add(j);
					}
				}
			}
			join[i] = values;
		}

		String jsonTab = "";
		int c = 0;

		jsonTab += "{";
		jsonTab += "\"mainftm\":<<MAINFTM>>,";
		jsonTab += "\"mainbtid\":\"<<MAINBTID>>\",";
		jsonTab += "\"response\": <<RESPONSE>>,";
		jsonTab += "\"header\":{";
			jsonTab += "\"userid\":\"<<USERID>>\",";
			jsonTab += "\"languageid\":\"<<LANGUAGEID>>\",";
			jsonTab += "\"branchid\":<<BRANCHID>>,";
			jsonTab += "\"officeid\":<<OFFICEID>>,";
			jsonTab += "\"deptoid\":<<DEPTOID>>,";
			jsonTab += "\"terminalid\":\"<<TERMINALID>>\",";
			jsonTab += "\"messengerid\":\"<<MESSENGERID>>\",";
			jsonTab += "\"sessionkey\":\"<<SESSIONKEY>>\",";
			jsonTab += "\"externalreference\":\"<<EXTERNALREFERENCE>>\",";
			jsonTab += "\"referenceuser\":\"<<REFERENCEUSER>>\",";
			jsonTab += "\"processtype\":\"<<PROCESSTYPE>>\"";
		jsonTab += "},";
		jsonTab += "\"ftms\":[";
		jsonTab += "{";
		// jsonTab += "\"fisa_object_id\":\"<<FISA_OBJECT>>\",";
		// jsonTab += "\"id\":\"<<ID>>\",";
		// jsonTab += "\"datakey\":\"<<DATAKEY>>\",";

		jsonTab += "\"tabs\":[";
		for (Object z : join) {

			jsonTab += "{";
			jsonTab += "\"multivalue\":\"<<MULTIVALUE." + c + ">>\",";
			jsonTab += "\"parent\":\"<<PARENT." + c + ">>\",";
			jsonTab += "\"id\":\"<<ID." + c + ">>\",";
			jsonTab += "\"recs\":[{";
			jsonTab += "\"fields\":" + z.toString();
			// jsonTab += "\",recstatus\": \"<<RECSTATUS."+c+">>\"";
			jsonTab += "}]";
			jsonTab += "}";
			if (c < join.length - 1) {
				jsonTab += ",";
			}
			c++;

		}

		jsonTab += "]";
		jsonTab += "}";
		jsonTab += "]"; // CLOSE FTM
		jsonTab += "}";
		/*---------------------------------------------------------------------*/
		// System.out.println(jsonTab);

		for (Entry<String, Object> entry : Entrada.getMetaData().entrySet()) {
			if (x.containsKey(entry.getKey())) {
				jsonTab = jsonTab.replace("<<" + x.get(entry.getKey()).getPosition() + ">>",
						String.valueOf(entry.getValue()));
			}

		}

		System.out.println(jsonTab);

		// Fm f = Converter.fromJsonString(jsonTab);
		// System.out.println(Converter.toJsonString(f));

		OtrFm f = org.objects.Converter.fromJsonString(jsonTab);
		System.out.println(org.objects.Converter.toJsonString(f));

		
		Connection connection_ = App.getOracleConnection();
		CallableStatement cs_ = connection_.prepareCall("{call PKG_CHR_CHARGES_CALL.PRO_RUN_X(?)}");

		PkgChrChargesCallProRun2 ctx_ = new PkgChrChargesCallProRun2();
		ctx_.setPrbFm(f);

		if (ctx_.getPrbFm() != null) {
			cs_.setObject(1, OtrFmConverter.getStruct(ctx_.getPrbFm(), connection_));
		} else {
			cs_.setNull(1, Types.STRUCT, "OTR_FM");
		}
		cs_.registerOutParameter(1, Types.STRUCT, "OTR_FM"); // PRB_FM
		cs_.execute();
		ctx_.setPrbFm(OtrFmConverter.getObject((Struct) cs_.getObject(1))); // PRB_FM

		System.out.println(ctx_.getPrbFm().getMainbtid());

		connection_.close();
		

		
		/*
		Connection connection = App.getOracleConnection();
		CallableStatement cs = connection.prepareCall("{call PKG_CHR_CHARGES_CALL.PRO_TEST(?)}");
		
		PkgChrChargesCallProTest ctx = new PkgChrChargesCallProTest();
		ctx.setHead(f.getHeader());
		
        if (ctx.getHead()!= null) {
            cs.setObject(1, OtrFmHeaderConverter.getStruct(ctx.getHead(), connection));
        } else {
            cs.setNull(1, Types.STRUCT, "OTR_FM_HEADER");
        }
        cs.registerOutParameter(1, Types.STRUCT, "OTR_FM_HEADER"); // PRB_FM
        cs.execute();
        ctx.setHead(OtrFmHeaderConverter.getObject((Struct)cs.getObject(1))); // PRB_FM		
		
		System.out.println(ctx.getHead().getBranchid());
	
		connection.close();
		
		*/
		//-----------------------------------------------------------------------------
				
		
	}

}
