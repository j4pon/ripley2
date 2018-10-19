package org.test;

import java.util.HashMap;

public class Parametros {
	/*
	public enum p_io{
		IN, OUT, INOUT
	}
	*/
	private String nivel;
	
	private String estructura;
	
	//private p_io parametro;
	
	private Object value;
	
	public Parametros(String nivel) {
		this.nivel = nivel;
	}
	public Parametros(String nivel, Object value) {
		this.nivel = nivel;
		this.value = value;
	}	
	public Parametros(String nivel, String estructura/*, p_io parametro*/) {
		this.nivel = nivel;
		this.estructura = estructura;
		//this.parametro = parametro;
	}	
	
	public Parametros(String nivel, String estructura,/* p_io parametro,*/ Object value) {
		this.nivel = nivel;
		this.estructura = estructura;
		//this.parametro = parametro;
		this.value = value;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getEstructura() {
		return estructura;
	}
	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}
	/*
	public p_io getParametro() {
		return parametro;
	}
	public void setParametro(p_io parametro) {
		this.parametro = parametro;
	}
	*/
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
