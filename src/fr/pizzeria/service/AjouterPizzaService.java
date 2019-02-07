package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;

import java.util.Scanner;


public class AjouterPizzaService extends MenuService {
	
	
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) {
		Pizza pizza = new Pizza(null, null, 0);
		
		System.out.println("Veuillez saisir le code :");
		pizza.setCode(read.next());
		System.out.println("Veuillez saisir le nom (sans espace) :");
		pizza.setLibbelle(read.next());
		System.out.println("Veuillez saisir le prix :");
		pizza.setPrix(read.nextDouble());

		dao.saveNewPizza(pizza);
		
	}




	
	
	


}
