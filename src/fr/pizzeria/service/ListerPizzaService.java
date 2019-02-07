package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.dao.*;
import fr.pizzeria.model.Pizza;

public class ListerPizzaService extends MenuService {
	
	

	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) {
	
		System.out.println("Les pizzas");
		
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			Pizza pizzaCurrent = (Pizza) dao.findAllPizzas().get(i);
			pizzaCurrent.affiche();
		}
		read.nextLine(); // pause jusqu'à l'action par l'utilisateur
		
	}

}
