package com.ciudad.model;

import jakarta.persistence.*;

@Entity
@Table(name="ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="codigo")
	private int codigo;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="numhabitantes")
	private int numHabitantes;
	
	public Ciudad() {
		super();
	}

	public Ciudad(int codigo, String nombre, int numHabitantes) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumHabitantes(int numHabitantes) {
		this.numHabitantes = numHabitantes;
	}
	
	
	
	
	
}
