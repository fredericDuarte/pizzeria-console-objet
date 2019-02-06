package fr.pizzeria.model;

public class Pizza {

	/* définitions des variables */
	public int id;
	public String code;
	public String libbelle;
	public double prix;

	/* constructeur */
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

	@Override
	public String toString() {
		return code + "-> " + libbelle + "(" + prix + ")";
	}

	public void affiche() {
		System.out.println(code + "-> " + libbelle + "(" + prix + ")");
	}

}
