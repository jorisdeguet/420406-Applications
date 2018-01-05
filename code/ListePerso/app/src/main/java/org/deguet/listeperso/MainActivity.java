package org.deguet.listeperso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.message;
import static org.deguet.listeperso.R.id.lv;

public class MainActivity extends AppCompatActivity {

    List<Truc> liste = new ArrayList<>();

    MonAdapteur adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0 ; i < 10 ; i++){
            Truc truc = new Truc();
            truc.a = "a"+i;
            truc.b = "b"+i;
            liste.add(truc);
        }

        ListView lv = (ListView) findViewById(R.id.lv);
        //ArrayAdapter<Truc> adapter = new ArrayAdapter<Truc>(this, android.R.layout.simple_list_item_1, liste);
        adapter = new MonAdapteur(this);
        adapter.addAll(liste);
        lv.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        MonAdapteur.bus.unregister(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        MonAdapteur.bus.register(this);
        super.onResume();
    }

    @Subscribe
    public void reagirAClicSurA(Truc t){
        // le supprimer de la liste
        liste.remove(t);
        // mettre à jour l'affichage
        adapter.clear();
        adapter.addAll(liste);
        adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void dupliquer(EvenementADuppliquer t){
        Toast.makeText(this, "dupliquer", Toast.LENGTH_SHORT).show();
        liste.add(t.t);
        // mettre à jour l'affichage
        adapter.clear();
        adapter.addAll(liste);
        adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void supprimer(EvenementSupprimer t){
        Toast.makeText(this, "supprimer", Toast.LENGTH_SHORT).show();
        liste.remove(t.t);
        // mettre à jour l'affichage
        adapter.clear();
        adapter.addAll(liste);
        adapter.notifyDataSetChanged();
    }
}
