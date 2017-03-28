package com.example.demodialogform;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class DialogFormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_form);
	}

	public void clickAndShow(View v){
		createAndShowDialog();
	}
	
	public void createAndShowDialog(){
		DialogFragment newFragment = new MonDialogFragment();
		newFragment.show(getFragmentManager(), "dialog");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog_form, menu);
		return true;
	}

}
