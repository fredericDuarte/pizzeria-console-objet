package fr.pizzeria.model;

/**
 * 
 * @author F.Duarte
 *
 */
public class Pizza {

	/* définitions des variables */
	public int id;
	public String code;
	public String libbelle;
	public double prix;

	/**
	 * constructeur avec paramétre
	 * 
	 * @param code
	 * @param libbelle
	 * @param prix
	 */
	public Pizza(String code, String libbelle, double prix) {
		super();
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
	}

	/**
	 * 
	 * @param id
	 * @param code
	 * @param libbelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libbelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
	}

	/**
	 * Affiche la description d'un pizza
	 */
	public void affiche() {
		System.out.println(code + "-> " + libbelle + "(" + prix + ")");
	}

}
