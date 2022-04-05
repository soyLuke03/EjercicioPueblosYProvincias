package com.jacaranda.utilities;

import java.util.Collection;

public class Provincia{

	//Atributos de Provincia
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
		
	private Collection<Provincia> pueblos;
		
	
	//Constructores de Provincia
	public Provincia (String nombre, String codigo) {
		this.nombre = nombre.toUpperCase();  //Debe de almacenarse en mayus.

		boolean esValido = false;								//2 caracteres numericos. Se lanza Exception. ok
		if (codigo.length() == 2) {
			for (int i = 0;i<codigo.length();i++) {
				if (Character.isDigit(codigo.charAt(i))) {
					esValido = true;
				}
				else {
					esValido = false;
				}
				if (esValido == true) {
					this.codigo = codigo;
				}
				else {
				throw new PuebloException("[ERROR] El codigo no es valido");
				}
			}
		}
	}
	
	
	//Metodos de Provincia 
	public boolean addPueblo​(String nombrePueblo, String codigo, int numeroHabitantes, 
							 double rentaPerCapita, double superficie) 
							 throws ProvinciaException {
		
		boolean anadirPueblo = false;
		
		//Lanzar una Exception si nombrePueblo es nulo.
		
		return anadirPueblo;
	}
	
	
	public boolean delPueblo(String pueblo) {
		
		boolean borrarPueblo = false;
		
		//Para borrar un Pueblo, debe de existir y estar almacenado.
		
		return borrarPueblo;
	}
	
	
	public String getInformacionPueblo(String pueblo) {
		
		String infoPueblo = "";
		
		return infoPueblo;
	}

	
	public String getProvincia() {
		
		return this.nombre;
	}
	
	
	public String listadoNombrePueblos() {
		
		return "";
	}
	
	
	public String listadoPueblos() {
		
		return pueblos.toString();
	}
	
	
	public Integer numPueblos() {
		
		return pueblos.size();
	}
	
	
	
	//Getters-Setters de Provincia
	public String getCodigo() {
		return codigo;
	}


	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(String pueblo, Integer numeroHabitantes) {
	
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}


	public void setRentaPerCapita(Double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(String pueblo, Double superficie) {
		
		//Si se cambia la superficie de un Pueblo, tambien 
		//cambiara la superficie de Provincia.
		
		this.superficie = superficie;
	}

	
	//toString() de Provincia
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	
	
}
