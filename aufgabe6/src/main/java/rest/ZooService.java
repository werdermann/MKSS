package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import zoo.Animal;
import zoo.Compound;

/**
 * Show compounds
 * http://localhost:8080/aufgabe8/rest/compounds
 *
 */

@Path("/compounds")
public class ZooService
{
	private static List<Compound> compounds = new ArrayList<Compound>();

	// Static data just for simplicity. Should not be done this way in real systems
	static
	{
		Compound c1 = new Compound("Cows", 100);
		c1.addAnimal(new Animal("Berta", "Cow", 3));
		c1.addAnimal(new Animal("Hans", "Cow", 2));
		c1.addAnimal(new Animal("Zulu", "Cow", 5));
		c1.addAnimal(new Animal("Moritz", "Dog", 3));
		compounds.add(c1);
		
		Compound c2 = new Compound("Horses", 100);
		c2.addAnimal(new Animal("Lightning", "Horse", 3));
		c2.addAnimal(new Animal("Sugar", "Horse", 1));
		compounds.add(c2);
	}
	
	
	@GET
	public String get()
	{
		return "Here should all compounds be listed";
	}
	
}
