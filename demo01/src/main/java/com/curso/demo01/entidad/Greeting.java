package com.curso.demo01.entidad;

public class Greeting {
	private Long id;
	private String saludo;
	
	
	public Greeting(Long id, String saludo) {
		super();
		this.id = id;
		this.saludo = saludo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSaludo() {
		return saludo;
	}
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
}
