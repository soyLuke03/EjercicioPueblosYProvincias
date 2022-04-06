package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class Provincia{

	//Atributos de Provincia
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
		
	private Collection<Pueblo> pueblos;
		
	
	//Constructores de Provincia
	public Provincia (String nombre, String codigo) {
		this.nombre = nombre.toUpperCase();  //Debe de almacenarse en mayus.
		if (nombre == null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
		this.setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0.0;
		this.superficie = 0.0;
		this.pueblos = new ArrayList<>();
	}
	
	
	//Metodos de Provincia 
	public boolean addPueblo​(String nombrePueblo, String codigo, int numeroHabitantes, 
							 double rentaPerCapita, double superficie)  throws ProvinciaException {
		
		boolean anadirPueblo = false;
		String codigoNuevo = this.codigo + codigo;
		if (nombre == null) {
			throw new ProvinciaException("El codigo no puede ser nulo");
		}
		if (existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo ya existe");
		} else {
			Pueblo p1 = new Pueblo(nombrePueblo, codigoNuevo, numeroHabitantes, rentaPerCapita, superficie );
			pueblos.add(p1);
			anadirPueblo = true;
			this.superficie += superficie;
			this.numeroHabitantes += numeroHabitantes;
			this.rentaPerCapita += rentaPerCapita;
		}
		
		
		return anadirPueblo;
	}
	
	
	public boolean delPueblo(String nombre) {
		boolean eliminado = false;
		
		for(Pueblo p : this.pueblos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				this.pueblos.remove(p);
				this.superficie -= p.getSuperficie();
				this.rentaPerCapita -= p.getRentaPerCapita();
				this.numeroHabitantes -= p.getNumeroHabitantes();
			}
		}
		return eliminado;
	}
	
	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean resultado = false;
		if (nombre==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		for (Pueblo pueblo : this.pueblos) {
			if (pueblo.getNombre().equalsIgnoreCase(nombre)) {
				resultado = true;
			}

		}
		return resultado;
	}

	
	
	public String getInformacionPueblo(String nombre) throws ProvinciaException {
		String resultado="";
		if (!existePueblo(nombre) || nombre==null) {
			resultado=null;
		}else {
			for (Pueblo p:this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					resultado=p.toString();
				}
			}
		}
		return resultado;
	}

	
	public String getProvincia() {
		
		return this.nombre;
	}
	
	
	public String listadoNombrePueblo() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p.getNombre() + "\n");
		}
		return cadenaNueva.toString();
	}
	
	
	public String listadoPueblos() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p);
		}
		return cadenaNueva.toString();
	}
	
	
	public Integer numPueblos() {
		
		return pueblos.size();
	}
	
	
	
	//Getters-Setters de Provincia
	public String getCodigo() {
		return codigo;
	}


	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
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
