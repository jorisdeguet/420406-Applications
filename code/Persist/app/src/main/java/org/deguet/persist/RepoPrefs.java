package org.deguet.persist;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
import static android.R.id.list;

/**
 * Created by joris on 17-01-17.
 *
 * Uses a list to hold all product and then put it in a serialised form in one preference
 *
 *
 *
 */

public class RepoPrefs implements CRUD<Product>{

    private static final String prefName = "DemoPrefs";

    private static RepoPrefs singleton;

    public static synchronized RepoPrefs get(Context context) {
        if (singleton == null) {
            SharedPreferences prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
            singleton = new RepoPrefs(prefs);
        }
        return singleton;
    }

    private SharedPreferences preferences;

    private RepoPrefs(SharedPreferences prefs){
        this.preferences = prefs;
    }

    private List<Product> load(){
        Gson gson = new Gson();
        String json = preferences.getString("list","[]");
        List<Product> list = gson.fromJson(json, new TypeToken<List<Product>>(){}.getType());
        return list;
    }

    private void save(List<Product> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        SharedPreferences.Editor edit = preferences.edit();
        edit.clear();
        edit.putString("list", json);
        edit.commit();
    }

    @Override
    public long save(Product o) {
        List<Product> list = load();
        o.setId(this.nextAvailableId());
        list.add(o);
        this.save(list);
        return o.getId();
    }

    @Override
    public Product getById(Long id) {
        for (Product p : getAll()){
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return load();
    }

    @Override
    public void deleteOne(Long id) {
        Product toDelete = null;
        List<Product> list = load();
        for (Product p : list){
            if (p.getId().equals(id)) toDelete = p;
        }
        if (toDelete == null) return;
        list.remove(toDelete);
        save(list);
    }

    @Override
    public void deleteAll() {
        save(new ArrayList<Product>());
    }

    private long nextAvailableId(){
        synchronized (this) {
            long max = 0;
            for (Product a : getAll()){
                if (a.getId() > max) max = a.getId();
            }
            return max+1;
        }
    }
}
