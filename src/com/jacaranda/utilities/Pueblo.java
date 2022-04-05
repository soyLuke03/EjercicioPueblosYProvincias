package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {

	//Atributos de Pueblo
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
	
	
	
	//Constructores de Pueblo
	public Pueblo(String nombre, String codigo, Integer numeroHabitantes, 
			  	  Double rentaPerCapita, Double superficie) 
				  throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();  		//Se debe almacenar en mayus.
		this.codigo = codigo;						//5 caracteres numericos. Se lanza Exception.
		this.numeroHabitantes = numeroHabitantes;	//Lanzar Exception si es negativo.
		this.rentaPerCapita = rentaPerCapita;		//Valor negativo ==> Exception
		this.superficie = superficie;				//Valor negativo ==> Exception
	}
	
	
	public Pueblo(String nombre, String codigo) {
		this.nombre = nombre;		//Se lanzan Exceptions como el constructor de arriba.
		this.codigo = codigo;
	}



	//Getters-Setters de Pueblo
	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(Integer numeroHabitantes) {
		//Se lanza Exception aqui si el valor es negativo.
		
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}


	public void setRentaPerCapita(Double rentaPerCapita) {
		//Exception aqui si el numero es negativo.
		
		this.rentaPerCapita = rentaPerCapita;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		
		//Aqui se debe poner una Exception.
		
		this.superficie = superficie;
	}


	public String getNombre() {
		return nombre;
	}


	public String getCodigo() {
		return codigo;
	}
	
	
	
	//hashCode() de Pueblo
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, numeroHabitantes, rentaPerCapita, superficie);
	}


	//equals() de Pueblo
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(numeroHabitantes, other.numeroHabitantes)
				&& Objects.equals(rentaPerCapita, other.rentaPerCapita) && Objects.equals(superficie, other.superficie);
	}
	
	@Override
	public Integer compareTo(Pueblo pueblo) {
		
		
		return -1;
	}
	
	
	//toString() de Pueblo
	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}


	
}
