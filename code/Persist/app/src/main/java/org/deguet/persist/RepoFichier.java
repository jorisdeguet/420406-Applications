package org.deguet.persist;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Makes one file per product. Uses the id as the file name.
 */
public class RepoFichier implements CRUD<Product> {

    Gson gson = new Gson();

    Class<Product> classe = Product.class;

    Context context;

    public RepoFichier(Context c){
        this.context = c;
        this.createStorage();
    }

    public List<Product> getAll() {
        synchronized (classe) {
            List<Product> res = new ArrayList<Product>();
            File base = context.getFilesDir();
            for (File f : base.listFiles()){
                try{
                    //System.out.println("File is "+f.getName());
                    if (f.isDirectory()) continue;
                    String content = FileUtils.readFileToString(f);
                    Product a = gson.fromJson(content, classe);
                    res.add(a);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            return res;
        }
    }

    @Override
    public void deleteOne(Long o){
        synchronized (classe) {
            File base = context.getFilesDir();
            File f = new File(base, o + ".produit");
            f.delete();
        }
    }

    public long save(Product a) {
        synchronized (classe) {
            // set the id
            if (a.getId() == null) a.setId(this.nextAvailableId());
            //
            String serialise = gson.toJson(a);
            File base = context.getFilesDir();
            try {
                FileUtils.writeStringToFile(new File(base, a.getId()+".produit"), serialise);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return a.getId();

        }
    }

    @Override
    public Product getById(Long id) {
        synchronized (classe) {
            String content;
            try {
                File base = context.getFilesDir();
                File f = new File(base,id+".produit");
                if (!f.exists()) return null;
                content = FileUtils.readFileToString(new File(base,id+".produit"));
                Product a = gson.fromJson(content, classe);
                return a;
            } catch (IOException e) {
                return null;
            }
        }
    }

    public void deleteAll() {
        deleteStorage();
        createStorage();
    }

    // autre methodes hors acces aux donnees pour la gestion.

    private long nextAvailableId(){
        synchronized (classe) {
            long max = 0;
            for (Product a : getAll()){
                if (a.getId() > max) max = a.getId();
            }
            return max+1;
        }
    }

    public void deleteStorage(){
        File base = context.getFilesDir();
        deleteFolder(base);
    }

    public void createStorage(){
        File base = context.getFilesDir();
        base.mkdirs();
    }

    private static void deleteFolder(File folder) {
        try{File[] files = folder.listFiles();
            if(files!=null) {
                for(File f: files) {
                    if(f.isDirectory())
                        deleteFolder(f);
                    else
                        f.delete();
                }
            }
            folder.delete();
        }catch(Exception e){}
    }

}
