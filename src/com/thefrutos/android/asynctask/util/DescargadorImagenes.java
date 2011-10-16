package com.thefrutos.android.asynctask.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class DescargadorImagenes {

	public static Bitmap descargarImagendownloadFile(
			String urlFicheroImagenADescargar) {
		Bitmap imagenDescargada = null;
		try {
			URL urlImagen = new URL(urlFicheroImagenADescargar);
			HttpURLConnection conn = (HttpURLConnection) urlImagen
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();
			imagenDescargada = BitmapFactory.decodeStream(is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagenDescargada;
	}
}
