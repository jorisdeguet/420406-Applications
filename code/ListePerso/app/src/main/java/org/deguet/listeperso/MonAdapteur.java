package org.deguet.listeperso;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Bus;

import static android.R.attr.resource;

/**
 * Created by joris on 17-01-12.
 */

public class MonAdapteur extends ArrayAdapter<Truc> {

    public Bus bus = new Bus();


    public MonAdapteur(Context context) {
        super(context, R.layout.list_item);
        bus.register(this);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View v = li.inflate(R.layout.list_item, null);
        final Truc truc = getItem(position);
        TextView tvA = (TextView) v.findViewById(R.id.tvA);
        TextView tvB = (TextView) v.findViewById(R.id.tvB);

        tvA.setText(truc.a);
        tvB.setText(truc.b);

        tvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Coucou "+truc.a, Toast.LENGTH_SHORT).show();
                EvenementSupprimer e = new EvenementSupprimer();
                e.t = truc;
                bus.post(e);
            }
        });

        tvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvenementADuppliquer e = new EvenementADuppliquer();
                e.t = truc;
                bus.post(e);
            }
        });

        return v; //super.getView(position, convertView, parent);
    }
}
