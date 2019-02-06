package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Pizza[] array = new Pizza[8];
		array[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		array[1]  = new Pizza(1, "MAR", "Margherita", 14.00);
		array[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		array[3]= new Pizza(3, "FRO", "La 4 fromages", 12.00);
		array[4]= new Pizza(4, "CAN", "La cannibale", 12.50);
		array[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		array[6]= new Pizza(6, "ORI", "L’orientale", 13.50);
		array[7] = new Pizza(7, "IND", "L’indienne", 14.00);
		

		int choix = 1;
		int index =0;
		boolean find = false;
		Scanner choixUser = new Scanner(System.in);

		while (true) {
			choixUser.reset();
			System.out.println("***** Pizzeria Administration *****\n");

			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizzas");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("votre choix : \n");
			choix = choixUser.nextInt();

			switch (choix) {
			case 1:
				choixUser.reset();
				System.out.println("Les pizzas");
		        for(int i=0; i<array.length;i++)
		        {
          
				//	System.out.println( array[i].code + "-> " + array[i].libbelle + "(" + array[i].prix + ")" );
					array[i].affiche();
		        }
		        
		        choixUser.nextLine();
				
				break;
			case 2:
			
				System.out.println("Veuillez saisir le code :");
				String code = choixUser.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String nom = choixUser.next();
				System.out.println("Veuillez saisir le prix :");
				double prix = choixUser.nextDouble();
				Pizza[] arrayTemp = new Pizza[array.length + 1] ;

				for (int i = 0; i < array.length; i++) {
					arrayTemp[i] = array[i];
				}
		
				arrayTemp[array.length] = new Pizza(code, nom, prix);
				array = arrayTemp;
				break;
				
			case 3:
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String code2 = choixUser.next();
				for (int i = 0; i < array.length; i++) {
					
					if(array[i].code.equals(code2))
					{ find=true; index=i;  break;}
				}
				if(find)
				{
					System.out.println("Veuillez saisir le nouveau code :");
					array[index].code = choixUser.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					array[index].libbelle = choixUser.next();
					System.out.println("Veuillez saisir le nouveau prix :");
					array[index].prix = choixUser.nextDouble();
					
				}
				else {
					System.out.println("Pizza inexistant");
				}
				
					
				break;
			case 4:
				System.out.println("Veuillez choisir le code de la pizza à supprimer.");
				code = choixUser.next();
				Pizza[] arrayTemp2 = new Pizza[array.length - 1] ;
				int iTemp = 0;
				for (int i = 0; i < array.length; i++) {
					
					if(array[i].code.equals(code)){  
						arrayTemp2[iTemp] = array[i];
						iTemp++;
					}
				}
				array = arrayTemp2;
	
	

				break;
			case 99:
				choixUser.close();
				break;
			default:
			
				break;

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

	}

	private static void initPizza() {

	}

}
