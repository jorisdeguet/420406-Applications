package com.example.demointentscanner;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clicScanner(View v){
        // utilise une libraire externe
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

    public void clicActivity(View v){
        Intent i = new Intent(this.getApplication(), OtherActivity.class);
        startActivity(i);
    }

    public void clicEmail(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "joris.deguet@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MEGA SUJET");
        startActivity(Intent.createChooser(emailIntent, "Envoyer le super courriel ..."));
    }

    public void clicURL(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCOH9PMOL-wGH29SYcNFlfbQ"));
        startActivity(browserIntent);
    }
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		// quand un resultat valide a ete trouve
		if (scanResult != null) {
            Toast.makeText(
                    getBaseContext(),
                    "result " + scanResult.getContents(),
                    Toast.LENGTH_SHORT).show();

			Log.i("Main","Scan result from scanner is  "+ scanResult.getContents());
		}
		
	}
	
}
