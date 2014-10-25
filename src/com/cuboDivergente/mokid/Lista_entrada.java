package com.cuboDivergente.mokid;

public class Lista_entrada {
	private int idImagen; 
	private String SSID; 
	private String seguridad; 
	private String BSSID;

	public Lista_entrada (int idImagen, String SSID, String seguridad, String BSSID) { 
	    this.idImagen = idImagen; 
	    this.SSID = SSID; 
	    this.seguridad = seguridad; 
	    this.BSSID = BSSID; 
	    
	}

	public String get_SSID() { 
	    return SSID; 
	}

	public String get_seguridad() { 
	    return seguridad; 
	}
	
	public String get_BSSID() { 
	    return BSSID; 
	}

	public int get_idImagen() {
	    return idImagen; 
	} 
}