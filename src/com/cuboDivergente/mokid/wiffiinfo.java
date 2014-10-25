package com.cuboDivergente.mokid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class wiffiinfo extends Activity {
	public RedWiffi red;
	// this context will use when we work with Alert Dialog
    final Context context = this;
    // just for test, when we click this button, we will see the alert dialog.
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wiffiinfo);
        Bundle data = getIntent().getExtras();
        if(data != null){
        	red = (RedWiffi)data.getSerializable("red");
        }
        TextView t_ssid = (TextView)findViewById(R.id.str_i_ssid);
        t_ssid.setText(red.SSID);
        TextView t_bssid = (TextView)findViewById(R.id.str_i_bbsid);
        t_bssid.setText(red.BSSID);
        TextView t_security = (TextView)findViewById(R.id.str_i_sec);
        t_security.setText(red.security);
        TextView t_power = (TextView)findViewById(R.id.str_i_pw);
        t_power.setText(Integer.toString(red.level));
        TextView t_frec = (TextView)findViewById(R.id.str_i_frec);
        t_frec.setText(Integer.toString(red.frecuencia));
    	TextView t_crack = (TextView)findViewById(R.id.str_i_crack);
    	t_crack.setText(red.pass);

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmokid, menu);
        return true;
    }

}
