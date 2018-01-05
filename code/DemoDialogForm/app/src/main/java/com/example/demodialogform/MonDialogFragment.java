package com.example.demodialogform;

import android.app.*;
import android.content.DialogInterface;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.Arrays;
import java.util.List;

import static com.example.demodialogform.R.id.code;
import static com.example.demodialogform.R.id.spinner;

public class MonDialogFragment extends DialogFragment {

    /**
     * Uses a standard dialog to handle the title and both positive and negative buttons
     * with a builder.
     *
     * We specified a custom view for the main part of the dialog.
     *
     * We access the custom view to retrieve the information.
     *
     * @param savedInstanceState
     * @return
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

        final EditText code = (EditText) v.findViewById(R.id.code);
        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);

        // add elements to spinner
        List<String> list = Arrays.asList("Homme","Femme");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sexes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Add action buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO Recover all values and perform the action
                        Toast.makeText(getActivity(), "Yo " + spinner.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Cancelled ", Toast.LENGTH_SHORT).show();
                        MonDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
