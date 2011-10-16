package com.thefrutos.android.asynctask.pojo;

import android.graphics.Bitmap;

public class Imagen {

	private String id;
	private String nombre;
	private String urlDescarga;
	private Bitmap imagen;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUrlDescarga(String urlDescarga) {
		this.urlDescarga = urlDescarga;
	}
	public String getUrlDescarga() {
		return urlDescarga;
	}
	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}
	public Bitmap getImagen() {
		return imagen;
	}
}
