package com.example.demodialogform;

import android.app.*;
import android.content.DialogInterface;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MonDialogFragment extends DialogFragment {
/*
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		// mise en place de l'interface a partir du XML
        final View v = inflater.inflate(R.layout.mon_dialog, container, false);
       
        // recuperation de chaque element d'interface
        final Button button = (Button)v.findViewById(R.id.add);
        final EditText code = (EditText) v.findViewById(R.id.code);
        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        
		// ajout des elements au spinner
        List<String> listes = Arrays.asList("Homme","Femme");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, listes);
		adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
		spinner.setAdapter(adapter);
		
       
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                

                MonDialogFragment.this.dismiss();
            }
        });

        return v;
    }
*/
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setTitle(R.string.mon_super_titre);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View v = inflater.inflate(R.layout.mon_dialog, null);
        builder.setView(v);
        // Add action buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        final EditText code = (EditText) v.findViewById(R.id.code);
                        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
                        // TODO
                        Toast.makeText(getActivity(), "Yo " + code.getText(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MonDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
