package com.cuboDivergente.mokid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Listado_redes extends Activity {

	boolean flag = false;
	private ListView lista;
	private WifiManager wm;
	private List<ScanResult> wl;
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	final Context context = this;
    private Button button;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado_redes);
		generarListas();
	}

	public void generarListas(){
		wm =(WifiManager) getSystemService(Context.WIFI_SERVICE);
		wm.startScan(); 
		wl=wm.getScanResults();
		for(int i = 0; i < wl.size(); i++){
			String SSID = wl.get(i).SSID;
			String BSSID = wl.get(i).BSSID;
			String capabilities = wl.get(i).capabilities;
			Log.d("MoKid", "SSID: " + SSID);
			Log.d("MoKid", "BSSID: " + BSSID);
			Log.d("MoKid", "Capabilities: " + capabilities);
			datos.add(new Lista_entrada(R.drawable.cc1, SSID, capabilities, BSSID));

		}
		
		lista = (ListView) findViewById(R.id.listadoRedes);
		lista.setAdapter(new Lista_adaptador(this, R.layout.celdawifi, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
				if (entrada != null) {
					TextView nombre = (TextView) view.findViewById(R.id.nombreRed); 
					if (nombre != null) 
						nombre.setText(((Lista_entrada) entrada).get_SSID()); 
					
					TextView seguridad  = (TextView) view.findViewById(R.id.seguridadRed); 
					if (seguridad != null) 
						seguridad.setText(((Lista_entrada) entrada).get_seguridad()); 
					
					TextView mac  = (TextView) view.findViewById(R.id.macRed); 
					if (mac != null) 
						mac.setText(((Lista_entrada) entrada).get_BSSID()); 					
					
					ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagenRed); 
					if (imagen_entrada != null)
						imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
				}
			}
		});
		
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, final int posicion, long id) {
			       /* Alert Dialog Code Start*/     
	            AlertDialog.Builder alert = new AlertDialog.Builder(context);
	            
	            alert.setTitle(wl.get(posicion).SSID); //Set Alert dialog title here
	            alert.setMessage("Ingrese la Contraseña de su Red"); //Message here
	 
	            // Set an EditText view to get user input 
	            final EditText input = new EditText(context);
	            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
	            alert.setView(input);
	 
	            alert.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int whichButton) {
	            	String pass = input.getEditableText().toString();
	            	RedWiffi redSel= new RedWiffi(wl.get(posicion).SSID, wl.get(posicion).BSSID, wl.get(posicion).capabilities,wl.get(posicion).level,wl.get(posicion).frequency,pass);
					Intent wifiinfo = new Intent(Listado_redes.this, wiffiinfo.class);
			  	  	wifiinfo.putExtra("red", redSel);
			  	  	startActivity(wifiinfo);
			  	  	overridePendingTransition(R.anim.left_in, R.anim.left_out);            
	            } // End of onClick(DialogInterface dialog, int whichButton)
	        }); //End of alert.setPositiveButton
	            alert.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
	              public void onClick(DialogInterface dialog, int whichButton) {
	                // Canceled.
	                  dialog.cancel();
	              }
	        }); //End of alert.setNegativeButton 
	            AlertDialog alertDialog = alert.create();
	            alertDialog.show();
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmokid, menu);
		return true;
	}
}
