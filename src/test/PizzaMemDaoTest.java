package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

class PizzaMemDaoTest {

	PizzaMemDao dao = new PizzaMemDao();
	private Pizza pizza;

	@BeforeEach
	void setUp() throws Exception {
		pizza = new Pizza("IND", "au jambon", 11);

	}

	@AfterEach
	void tearDown() throws Exception {
		pizza = null;
	}

	@Test
	void testAjout() throws SavePizzaException {
		// vérifie si la liste des pizza est vide
		assertTrue("Dao doit étre vide", dao.findAllPizzas().isEmpty());
		// Ajout d un nouveau pizza
		dao.saveNewPizza(new Pizza(0, "PEP", "Pépéroni", 12.50));
		// vérifie que le code d'un pizza demandé n'est pas trouvé dans la liste
		assertTrue("Je n'ai pas retouvé mon pizza", dao.findPizzaByCode("test").getLibbelle().equals(""));

	}

	@Test
	void testModif() {
		// ajour un nouveau pizza défini
		try {
			dao.saveNewPizza(pizza);
		} catch (SavePizzaException e) {

			System.out.println(e.getMessage());
		}
		// véirfie si l'instance est crée
		assertNotNull("L'instance est-il créée?", pizza);
		// mise à jours
		pizza.setLibbelle("aux oeufs");
		pizza.setPrix(13);
		try {
			dao.updatePizza("IND", pizza);
		} catch (UpdatePizzaException e) {

			System.out.println(e.getMessage());
		}
		// vérifie que le nouveau pizza existe via le code
		assertTrue("le code doit exister", dao.pizzaExists("IND"));

	}

	@Test
	void testDelete() {
		// supprime un pizza via le code
		try {
			dao.deletePizza("IND");
		} catch (DeletePizzaException e) {

			System.out.println(e.getMessage());
		}
		// vérifie que le pizza supprimé existe via le code
		assertTrue("le code doit exister", dao.pizzaExists("IND"));
		// compare le code d'un pizza est identique à l'instance
		assertEquals("Le nom est incorrect", "COR", pizza.getCode());

	}

}
