package rest;

import jakarta.ws.rs.*;
import org.json.JSONObject;
import zoo.Animal;
import zoo.Compound;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 * Show compounds
 * http://localhost:8080/aufgabe_rest/rest/compounds
 */
@Path("/compounds")
public class ZooService {
	private static final List<Compound> compounds = new ArrayList<>();

	// Static data just for simplicity. Should not be done this way in real systems
	static {
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


	/**
	 *  Get all existing compounds.
	 *  http://localhost:8080/aufgabe_rest_war/rest/compounds
	 *  HTTP-Method: GET
	 *  In Parameters: -
	 *  Out Parameter: String (JSON Compounds)
	 */
	@GET
	public String getCompounds() {
		String result = "";

		for(int i = 0; i < compounds.size(); i++) {
			Compound compound = compounds.get(i);
			if(i + 1 == compounds.size()) {
				result += toJsonCompound(compound).toString();
			} else {
				result += toJsonCompound(compound) + ",";
			}
		}
		return result;
	}

	/**
	 *  Get a compound by name.
	 *  http://localhost:8080/aufgabe_rest_war/rest/compounds/{name}
	 *  HTTP-Method: GET
	 *  In Parameters: String name
	 *  Out Parameter: String (JSON Compound)
	 */
	@GET
	@Path("/{name}")
	public String getCompound(@PathParam("name") String compoundname) {
		for(Compound compound: compounds) {
			if(compound.getName().equals(compoundname)) {
				return toJsonCompound(compound).toString();
			}
		}
		return "Error: Compound not found";
	}

	/**
	 *  Get an animal by name
	 *  http://localhost:8080/aufgabe_rest_war/rest/compounds/animal/{name}
	 *  HTTP-Method: GET
	 *  In Parameters: String name
	 *  Out Parameter: String (JSON Animal)
	 */
	@GET
	@Path("/animal/{name}")
	public String showAnimal(@PathParam("name") String animalname) {

		for (Compound compound: compounds) {
			for (Animal animal: compound.getAnimals()) {
				if(animal.getName().equals(animalname)) {
					JSONObject json = toJsonAnimal(animal, compound.getName());
					return json.toString();
				}
			}
		}
		return "Error: Animal not found!";
	}

	/**
	 *  Add an animal to a compound.
	 *  http://localhost:8080/aufgabe_rest_war/rest/compounds/animal/addAnimal
	 *  HTTP-Method: POST
	 *  In Parameters: String JSON (compoundName, animalName, type, age)
	 *  Out Parameter: -
	 */
	@POST
	@Path("/animal/addAnimal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAnimal(String json) {
		JSONObject data = new JSONObject(json);
		String compoundName = data.getString("compoundName");
		String name = data.getString("animalName");
		String type = data.getString("type");
		double age = data.getDouble("age");

		for(Compound compound: compounds) {
			if(compound.getName().equals(compoundName)) {
				compound.addAnimal(new Animal(name, type, age));
			}
		}

	}

	/**
	 *  Remove an animal from a compoud
	 *  http://localhost:8080/aufgabe_rest_war/rest/compounds/animal/deleteAnimal
	 *  HTTP-Method: DELETE
	 *  In Parameters: String JSON (compoundName, animalName)
	 *  Out Parameter: -
	 */
	@DELETE
	@Path("/deleteAnimal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAnimal(String json) {
		JSONObject data = new JSONObject(json);

		String compoundName = data.getString("compoundName");
		String animalName = data.getString("animalName");

		for(int i = 0; i < compounds.size(); i++) {
			for(int j = 0; j < compounds.get(i).getAnimals().size(); j++) {
				if(compounds.get(i).getName().equals(compoundName)) {
					if(compounds.get(i).getAnimals().get(j).getName().equals(animalName)) {
						compounds.get(i).removeAnimal(compounds.get(i).getAnimals().get(j));
					}
				}
			}
		}
	}

	public static JSONObject toJsonCompound(Compound c) {
		JSONObject json = new JSONObject();
		json.put("name", c.getName());
		json.put("size", c.getSize());
		json.put("href", "http://localhost:8080/aufgabe_rest_war/rest/compounds/" + c.getName());
		String animals = "";

		for(int i = 0; i < c.getAnimals().size(); i++) {
			if(c.getAnimals().size() == i +1) {
				animals += toJsonAnimal(c.getAnimals().get(i), c.getName()).toString();
			} else {
				animals += toJsonAnimal(c.getAnimals().get(i), c.getName()) + ",";
			}
		}
		json.put("animals", animals);
		return json;
	}

	public static JSONObject toJsonAnimal(Animal a, String compoundName) {
		JSONObject json = new JSONObject();
		json.put("name", a.getName());
		json.put("type", a.getType());
		json.put("age", a.getAge());
		json.put("href", "http://localhost:8080/aufgabe_rest_war/rest/compounds/animal/" + a.getName());
		json.put("compound", "http://localhost:8080/aufgabe_rest_war/rest/compounds/" + compoundName);
		return json;
	}

}
