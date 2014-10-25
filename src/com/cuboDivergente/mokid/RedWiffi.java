package com.cuboDivergente.mokid;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RedWiffi implements Serializable
{
	public String SSID;
	public String BSSID;
	public String security;
	public int level;
	public int frecuencia;
	public String pass;
	
	public RedWiffi(String SSID,String BSSID,String security,int level,int frecuencia,String pass){
		this.SSID=SSID;
		this.BSSID=BSSID;
		this.security=security;
		this.level=level;
		this.frecuencia=frecuencia;
		this.pass=pass;
	}
}