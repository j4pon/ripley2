package org.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.model.Converter;
import org.model.Fm;


public class test {
	public static void main(String[] args) throws IOException {
		
		/*---------------------------------------------------------------------*/		
		HashMap<String, Elementos> x  = CreaCtaD.Layout().getLayout();

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
				if(entry.getValue().getIsArray()){
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

		String jsonTab= "";
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
		//jsonTab += "\"fisa_object_id\":\"<<FISA_OBJECT>>\",";
		//jsonTab += "\"id\":\"<<ID>>\",";
		//jsonTab += "\"datakey\":\"<<DATAKEY>>\",";		
		
		jsonTab += "\"tabs\":[";
		for (Object z : join) {

			jsonTab += "{";
			jsonTab += "\"multivalue\":\"<<MULTIVALUE."+c+">>\",";
			jsonTab += "\"parent\":\"<<PARENT."+c+">>\",";
			jsonTab += "\"id\":\"<<ID."+c+">>\",";
			jsonTab += "\"recs\":[{";
			jsonTab += "\"fields\":" + z.toString();
			//jsonTab += "\",recstatus\": \"<<RECSTATUS."+c+">>\"";
			jsonTab += "}]";
			jsonTab += "}";
			if(c < join.length-1){
				jsonTab += ",";
			}
			c++;			
		
		}
		
		jsonTab += "]";
		jsonTab += "}";
		jsonTab += "]";	//CLOSE FTM
		jsonTab += "}";
		/*---------------------------------------------------------------------*/
		//System.out.println(jsonTab);
		
		
		
		
		for(Entry<String, Object> entry : Entrada.getMetaData().entrySet()){
				if(x.containsKey(entry.getKey())){
					jsonTab = jsonTab.replace("<<"+x.get(entry.getKey()).getPosition()+">>", String.valueOf(entry.getValue()));
				}
			
		}
		
		System.out.println(jsonTab);
		
		
		Fm f = Converter.fromJsonString(jsonTab);
	
		System.out.println(Converter.toJsonString(f));
		

	}


}
