package org.deguet.persist;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public abstract class TestAbstract {
	
	CRUD<Product> repository;

    @Before
    public void setUp() throws Exception {

        repository = getRepo();
        repository.deleteAll();

    }

    public abstract CRUD<Product> getRepo();

    @After
	public void tearDown() throws Exception {

		repository.deleteAll();
		repository = null;
	}

    @Test
	public void testSaveAndGetAll(){
		Product p = new Product();
		p.setNom("Produit ");
		p.setPrixUnitaire(10);
		p.setTax(Product.TaxType.BaseProduct);
		repository.save(p);
		assertEquals(repository.getAll().size(), 1);
	}

    @Test
    public void testSaveManyAndGetAll(){
        List<Product> prods = new ArrayList<Product>();
        int size = 22;
        for (int i = 0 ; i < size ; i++){
            Product p = new Product();
            p.setNom("Produit " + i);
            p.setPrixUnitaire(i*10);
            p.setTax(Product.TaxType.BaseProduct);
            prods.add(p);
            repository.save(p);
        }
        assertEquals(prods.size(), repository.getAll().size());
    }

    @Test
	public void testGetById(){
		Product p = new Product();
		p.setNom("Produit ");
		p.setPrixUnitaire(10);
		p.setTax(Product.TaxType.BaseProduct);
        long tested = repository.save(p);
        Product recov = repository.getById(tested);
		assertEquals(recov.getPrixUnitaire().intValue(), 10);
	}

    @Test
    public void testDeleteOneById(){
        Product p = new Product();
        p.setNom("Produit ");
        p.setPrixUnitaire(10);
        p.setTax(Product.TaxType.BaseProduct);
        repository.save(p);
        assertEquals(1, repository.getAll().size());
        repository.deleteOne(p.getId());
        Log.i("TestsCRUD",repository.getAll().toString());
        assertEquals(0, repository.getAll().size());
    }

    @Test
    public void testDeleteAll(){
        List<Product> prods = new ArrayList<Product>();
        int size = 22;
        for (int i = 0 ; i < size ; i++) {
            Product p = new Product();
            p.setNom("Produit " + i);
            p.setPrixUnitaire(i * 10);
            p.setTax(Product.TaxType.BaseProduct);
            prods.add(p);
            repository.save(p);
        }
        assertEquals(size, repository.getAll().size());
        repository.deleteAll();
        assertEquals(0, repository.getAll().size());
    }

    @Test
    public void testSaveOnePerformance(){
        long a = System.currentTimeMillis();
        for (int i = 0 ; i < 400 ; i++){
            Product p = new Product();
            p.setNom("Produit " + i);
            p.setPrixUnitaire(i*10);
            p.setTax(Product.TaxType.BaseProduct);
            repository.save(p);
        }
        long b = System.currentTimeMillis();
        Log.i("TestLoad", repository.getClass().getSimpleName()+"  : temps est " + (b - a) + " ms");
    }

    @Test
    public void testDrolesDeTypes(){
        String japanese = "日本語";
        Product p = new Product();
        p.setNom(japanese);
        p.setPrixUnitaire(Integer.MAX_VALUE);
        p.setTax(Product.TaxType.BaseProduct);
        long id = repository.save(p);

        // recover and tests for equality
        Product recov = repository.getById(id);
        assertEquals(japanese,                   recov.getNom());
        assertEquals(Integer.MAX_VALUE,          recov.getPrixUnitaire().intValue());
    }

}
