
package com.thefrutos.android.asynctask;

import java.util.HashMap;
import java.util.Map;

import android.app.Application;

import com.thefrutos.android.asynctask.pojo.Imagen;

public class AsyncTaskApplication extends Application {

	public static Map<String, Imagen> elementosAplicacion = new HashMap<String, Imagen>();
}
