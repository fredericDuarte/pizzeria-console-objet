package fr.pizzeria.model;

public class Pizza {
	
	int id;
	String code;
	String libbelle;
	double prix;
	
	public Pizza(String code, String libbelle, double prix) {
		super();
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
	}
	public Pizza(int id, String code, String libbelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
	}
	

}
