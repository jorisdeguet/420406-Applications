package org.deguet.persist;

import static android.R.attr.description;

public class Product {
	
	private Long id;
	public enum TaxType { BaseProduct, TaxedProduct};
	private TaxType tax;
	private String nom;
	private Integer prixUnitaire;

	public void setId(long i) {
		this.id = i;
	}
	public Long getId() {
		return id;
	}

	public Product(){}

	public TaxType getTax() {return tax;}
	public void setTax(TaxType taxe) {this.tax = taxe;}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Product(TaxType taxe, String nom, String description, String codeBarre,
			Integer prixUnitaire) {
		super();
		this.tax = taxe;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", taxe=" + tax + ", nom=" + nom
				+ ", description=" + description +  ", prixUnitaire=" + prixUnitaire + "]";
	}
}
