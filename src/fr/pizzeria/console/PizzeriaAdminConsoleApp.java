package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner choixUser = new Scanner(System.in);
		Pizza pizza;
		int[] array = new int[0];
		int choix = 1;


		while (true) {
			
			System.out.println("***** Pizzeria Administration *****\n");

			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizzas");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("votre choix : \n");
			choix = choixUser.nextInt();
			
			switch(choix)
			{
			case 1: affichePizza();  break;
			case 2: ajoutPizza(); break;
			case 3: majPizza(); break;
			case 4: delpizza(); break;
			case 99:  break;
			default: affichePizza(); break;
			
			}

		}

	}

	private static void delpizza() {
		// TODO Auto-generated method stub
		
	}

	private static void majPizza() {
		// TODO Auto-generated method stub
		
	}

	private static void ajoutPizza() {
		// TODO Auto-generated method stub
		
	}

	private static void affichePizza() {
		// TODO Auto-generated method stub
		
	}

}
