package com.thefrutos.android.asynctask.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.thefrutos.android.R;
import com.thefrutos.android.asynctask.AsyncTaskApplication;
import com.thefrutos.android.asynctask.pojo.Imagen;
import com.thefrutos.android.asynctask.util.DescargadorElementosAsincrono;

public class PantallaPrincipal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new EjecutorEnAsincrono().execute();
		LinearLayout layoutImagenes = (LinearLayout) findViewById(R.id.layoutImagenes);
		crearImagenesEnVista(layoutImagenes);
	}
	
	private void crearImagenesEnVista(LinearLayout layoutImagenes) {
		ImageView imagen1 = new ImageView(this);
	    imagen1.setImageBitmap(AsyncTaskApplication.elementosAplicacion.get("imagen1").getImagen());
	    imagen1.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
	    imagen1.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    layoutImagenes.addView(imagen1);
	    ImageView imagen2 = new ImageView(this);
	    imagen2.setImageBitmap(AsyncTaskApplication.elementosAplicacion.get("imagen2").getImagen());
	    imagen2.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
	    imagen2.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    layoutImagenes.addView(imagen2);
	    ImageView imagen3 = new ImageView(this);
	    imagen3.setImageBitmap(AsyncTaskApplication.elementosAplicacion.get("imagen3").getImagen());
	    imagen3.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
	    imagen3.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    layoutImagenes.addView(imagen3);
	}

	private class EjecutorEnAsincrono extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			cargadorDeObjetosDePrueba();
			descargarImagenes();
			return null;
		}

		private void descargarImagenes() {
			DescargadorElementosAsincrono descargador = new DescargadorElementosAsincrono("descargador_imagenes");
			descargador.start();
			Handler handlerDescargador = descargador.getHandlerDescargador();
			for(Imagen imagen : AsyncTaskApplication.elementosAplicacion.values()) {
				Message msgImagen = new Message();
				msgImagen.obj = imagen;
				handlerDescargador.sendMessage(msgImagen);
			}
		}

		private void cargadorDeObjetosDePrueba() {
			Imagen imagen1 = new Imagen();
			imagen1.setId("imagen1");
			imagen1.setNombre("Imagen numero 1");
			imagen1.setUrlDescarga("http://cache2.allpostersimages.com/p/LRG/12/1259/XQ4T000Z/posters/arenas-nelly-manzana-verde.jpg");
			AsyncTaskApplication.elementosAplicacion.put("imagen1", imagen1);
			Imagen imagen2 = new Imagen();
			imagen2.setId("imagen2");
			imagen2.setNombre("Imagen numero 2");
			imagen2.setUrlDescarga("http://cache2.allpostersimages.com/p/LRG/12/1259/XQ4T000Z/posters/arenas-nelly-manzana-verde.jpg");
			AsyncTaskApplication.elementosAplicacion.put("imagen2", imagen2);
			Imagen imagen3 = new Imagen();
			imagen3.setId("imagen3");
			imagen3.setNombre("Imagen numero 3");
			AsyncTaskApplication.elementosAplicacion.put("imagen3", imagen3);
			imagen3.setUrlDescarga("http://1.bp.blogspot.com/_e2VvUqxTJQE/SWyeQdkh3DI/AAAAAAAAApY/qtaEF2SFFVs/s400/Amarillo.jpg");
		}
		
	}
	
}
