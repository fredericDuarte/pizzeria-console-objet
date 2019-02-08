package fr.pizzeria.model;

/**
 * 
 * @author F.Duarte
 *
 */
public class Pizza {

	/* définitions des variables */
	private int id;
	private String code;
	private String libbelle;
	private double prix;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibbelle() {
		return libbelle;
	}

	public void setLibbelle(String libbelle) {
		this.libbelle = libbelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
