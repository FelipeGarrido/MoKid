package com.cuboDivergente.mokid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Mainmokid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmokid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmokid, menu);
        return true;
    }
    
    public void clickIrRedes(View v){
    	Toast.makeText(this, "Escaneando redes wifi...", Toast.LENGTH_SHORT).show();
		Intent act = new Intent(Mainmokid.this, Listado_redes.class );
		startActivity(act);
		overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

}
