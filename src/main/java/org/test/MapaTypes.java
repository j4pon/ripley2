package org.test;

public class MapaTypes {

	
	private static MapaTypes instance=null;
	
	private static MapaTypes getInstance(){
		
		if(instance == null){
			instance = new MapaTypes();
		}
		return instance;
	}
	
	protected MapaTypes(){}
	
	
	
}
