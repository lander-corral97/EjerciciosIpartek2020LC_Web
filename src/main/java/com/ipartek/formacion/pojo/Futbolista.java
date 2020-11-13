package com.ipartek.formacion.pojo;

public class Futbolista {

	private static final int EDAD_MIN = 0;
	private static final int EDAD_MAX = 120;

	private static final float ALTURA_MIN = 0.0f;
	private static final float ALTURA_MAX = 3.0f;

	private int id;
	private String nombre;
	private int edad;
	private float altura;
	private String nacionalidad;
	private String equipo;

	public Futbolista() {
		super();
		this.id = 0;
		this.nombre = "";
		this.edad = 0;
		this.altura = 0f;
		this.nacionalidad = "";
		this.equipo = "";
	}

	public Futbolista(int id, String nombre, String equipo) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.equipo = equipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		if (edad < EDAD_MIN || edad > EDAD_MAX) {
			throw new Exception(String.format("Edad incorrecta. Debe ser entre %s y %s", EDAD_MIN, EDAD_MAX));
		} else {
			this.edad = edad;
		}
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) throws Exception {
		if (altura < ALTURA_MIN || altura > ALTURA_MAX) {
			throw new Exception(String.format("Altura incorrecta. Debe ser entre %s y %s", ALTURA_MIN, ALTURA_MAX));
		} else {
			this.altura = altura;
		}
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return String.format(
				"Nombre: %s\nEdad: %s\nAltura: %s m\nNacionalidad: %s\nEquipo: %s\n----------------------------------",
				this.nombre, this.edad, this.altura, this.nacionalidad, this.equipo);
	}

}
