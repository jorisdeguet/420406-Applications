package org.deguet.persist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.id.list;
import static org.deguet.persist.R.string.prefs;
import static org.deguet.persist.R.string.sql;


public class DemoActivity extends Activity {

    CRUD<Product> repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        final CRUD<Product> sql = RepoSQLite.get(getApplicationContext(), "DataBaseMain", 4);
        final CRUD<Product> fichiers = new RepoFichier(getApplicationContext());
        final CRUD<Product> prefs = RepoPrefs.get(getApplicationContext());

        ListView lvfichiers = (ListView) findViewById(R.id.lvfichiers);
        final ArrayAdapter<Product> adapterfichiers = new ArrayAdapter<Product>(getBaseContext(),android.R.layout.simple_list_item_1, new ArrayList<Product>());
        lvfichiers.setAdapter(adapterfichiers);

        findViewById(R.id.ajout_fichiers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fichiers.save(makeOne());
                adapterfichiers.clear();
                adapterfichiers.addAll(fichiers.getAll());
                adapterfichiers.notifyDataSetChanged();
            }
        });

        findViewById(R.id.vider_fichiers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fichiers.deleteAll();
                adapterfichiers.clear();
                adapterfichiers.addAll(fichiers.getAll());
                adapterfichiers.notifyDataSetChanged();
            }
        });
        ListView lvprefs = (ListView) findViewById(R.id.lvprefs);
        final ArrayAdapter<Product> adapterprefs = new ArrayAdapter<Product>(getBaseContext(),android.R.layout.simple_list_item_1, new ArrayList<Product>());
        lvprefs.setAdapter(adapterprefs);

        findViewById(R.id.ajout_prefs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.save(makeOne());
                adapterprefs.clear();
                adapterprefs.addAll(prefs.getAll());
                adapterprefs.notifyDataSetChanged();
            }
        });

        findViewById(R.id.vider_prefs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.deleteAll();
                adapterprefs.clear();
                adapterprefs.addAll(prefs.getAll());
                adapterprefs.notifyDataSetChanged();
            }
        });

        Toast.makeText(getApplicationContext(), "Pensez à exécuter les tests unitaires du projet", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo_sqlite, menu);
        return true;
    }

    public Product makeOne(){
        Product p = new Product();
        List<String> base = Arrays.asList("Quiche", "Pizza", "Spaghetti", "Lasagne");
        List<String> mode = Arrays.asList("bolognese", "végé", "Joris", "mexicaine");
        Random r= new Random();
        p.setNom(base.get(r.nextInt(base.size()))+" a la "+mode.get(r.nextInt(mode.size())));
        p.setPrixUnitaire(10+r.nextInt(100));
        p.setTax(Product.TaxType.BaseProduct);
        return p;
    }
    
}
