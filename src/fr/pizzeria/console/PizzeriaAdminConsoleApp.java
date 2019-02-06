package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author F.Duarte
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		/* D�finiions des pizzas */
		Pizza[] array = new Pizza[8];
		array[0] = new Pizza(0, "PEP", "P�p�roni", 12.50);
		array[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		array[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		array[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		array[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		array[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		array[6] = new Pizza(6, "ORI", "L�orientale", 13.50);
		array[7] = new Pizza(7, "IND", "L�indienne", 14.00);

		/* d�fintiions des variables */
		int choix = 1; // pour la saisie de l'utilisateur
		int index = 0; // pour la position de l'index
		boolean find = false; // condition

		/* d�finitions pour la saisie au clavier */
		Scanner choixUser = new Scanner(System.in);

		while (true) {

			/* Affichage d'un menu */
			System.out.println("***** Pizzeria Administration *****\n");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre � jour une pizzas");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("votre choix : \n");
			choix = choixUser.nextInt(); // saisie clavier par l'utilisateur

			/*  */
			switch (choix) {
			case 1:
				/* Affiche la liste des pizzas */
				System.out.println("Les pizzas");
				for (int i = 0; i < array.length; i++) {
					array[i].affiche();
				}
				choixUser.nextLine(); // pause jusqu'� l'action par l'utilisateur
				break;

			case 2:
				// Affiche les messages et r�cup�re les saisies pour pour cr�er un nouveau pizza

				System.out.println("Veuillez saisir le code :");
				String code = choixUser.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String nom = choixUser.next();
				System.out.println("Veuillez saisir le prix :");
				double prix = choixUser.nextDouble();
				// cr�e un tableau temporaire avec la nouvelle taille
				Pizza[] arrayTemp = new Pizza[array.length + 1];
				// copie la liste
				for (int i = 0; i < array.length; i++) {

				}
				// ajoute un nouveau pizza dans le tableau temporaire qui contient liste
				arrayTemp[array.length] = new Pizza(code, nom, prix);
				// r�cup�re la nouvelle liste
				array = arrayTemp;
				break;

			case 3:
				// pour la modification d'un pizza existant
				System.out.println("Veuillez choisir le code de la pizza � modifier.");
				String code2 = choixUser.next();
				// recherche le pizza demand�
				for (int i = 0; i < array.length; i++) {

					if (array[i].code.equals(code2)) {
						find = true;
						index = i; // r�cup�re la position de l'index
						break;
					}
				}
				if (find) { // vraie si le pizza demand� existe alors on entre les saisies
					System.out.println("Veuillez saisir le nouveau code :");
					array[index].code = choixUser.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					array[index].libbelle = choixUser.next();
					System.out.println("Veuillez saisir le nouveau prix :");
					array[index].prix = choixUser.nextDouble();

				} else {
					System.out.println("Pizza inexistant");
				}

				break;
			case 4:
				// demande le code pour le pizza � supprimer
				System.out.println("Veuillez choisir le code de la pizza � supprimer.");
				code = choixUser.next();
				// cr�e un tableau temporaire avec la nouvelle taille
				Pizza[] arrayTemp2 = new Pizza[array.length - 1];
				int iTemp = 0;
				// copie la liste sauf pour le pizza demand�
				for (int i = 0; i < array.length; i++) {
					if (!array[i].code.equals(code)) {
						arrayTemp2[iTemp] = array[i];
						iTemp++;
					}
				}
				// r�cup�re la nouvelle liste
				array = arrayTemp2;

				break;
			case 99:
				choixUser.close(); // quitte le programme
				break;

			}

		}

	}
}
