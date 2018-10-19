package org.test;

public class Elementos {
	private String elementReplace;
	private int indiceArray;
	private	String position;
	private Boolean isArray;
	private et tipoDato;
	
	public enum et {
		VARCHAR,
		NUMBER, 
		DATE
	}
	
	public Elementos(int indiceArray, String position, Boolean isArray) {
		this.indiceArray = indiceArray;
		this.position = position;
		this.isArray = isArray;
		this.tipoDato = et.VARCHAR;
	}
	
	public Elementos(int indiceArray, String position, Boolean isArray, et tipoDato) {
		this.indiceArray = indiceArray;
		this.position = position;
		this.isArray = isArray;
		this.tipoDato = tipoDato;
	}
	

	public String getElementReplace() {
		return elementReplace;
	}

	public void setElementReplace(String elementReplace) {
		this.elementReplace = elementReplace;
	}

	public int getIndiceArray() {
		return indiceArray;
	}

	public void setIndiceArray(int indiceArray) {
		this.indiceArray = indiceArray;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getIsArray() {
		return isArray;
	}

	public void setIsArray(Boolean isArray) {
		this.isArray = isArray;
	}

	public et getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(et tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	
}
