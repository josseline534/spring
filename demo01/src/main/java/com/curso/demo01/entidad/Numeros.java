package com.curso.demo01.entidad;

public class Numeros {
	private Long id;
	private Integer num1;
	private Integer num2;
	private String operacion;
	private Double resultado;
	
	public Numeros(Long id, Integer num1, Integer num2, String operacion, Double resultado) {
		super();
		this.id = id;
		this.num1 = num1;
		this.num2 = num2;
		this.operacion = operacion;
		this.resultado = resultado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum1() {
		return num1;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public Integer getNum2() {
		return num2;
	}

	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
	
	
}
