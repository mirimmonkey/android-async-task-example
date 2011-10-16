package com.thefrutos.android.asynctask.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import com.thefrutos.android.asynctask.AsyncTaskApplication;
import com.thefrutos.android.asynctask.pojo.Imagen;

public class DescargadorElementosAsincrono extends HandlerThread {

	private Handler handlerDescargador;

	public DescargadorElementosAsincrono(String name) {
		super(name);
	}

	public Handler getHandlerDescargador() {
		if (handlerDescargador == null) {
			handlerDescargador = new Handler(getLooper(), new HandlerListener());
		}
		return handlerDescargador;
	}

	private class HandlerListener implements Callback {

		public boolean handleMessage(Message msgImagenDescargar) {
			Log.d("DescargadorElementosAsincrono",
					"Comenzamos a descargar elemento");
			Imagen imagenADescargar = (Imagen) msgImagenDescargar.obj;
			Bitmap imagenDescargada = DescargadorImagenes
					.descargarImagendownloadFile(imagenADescargar
							.getUrlDescarga());
			AsyncTaskApplication.elementosAplicacion.get(
					imagenADescargar.getId()).setImagen(imagenDescargada);
			Log.d("DescargadorElementosAsincrono",
					"Descargado el elemento de la url "
							+ imagenADescargar.getUrlDescarga());
			return true;
		}
	}
}
