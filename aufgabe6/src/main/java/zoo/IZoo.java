package zoo;

import java.util.List;

/**
 *  Interface for a zoo.
 */
public interface IZoo
{
	/**
	 *  Get all existing compounds.
	 *  @return The compounds.
	 */
	public List<Compound> getCompounds();
	
	/**
	 *  Get a compound by name.
	 *  @param compoundname The name.
	 *  @return The compound.
	 */
	public Compound getCompound(String compoundname);
	
	/**
	 *  Get an animal by name.
	 *  @param animalname
	 *  @return The animal.
	 */
	public Animal showAnimal(String animalname);
	
	/**
	 *  Add an animal to a compound.
	 *  @param ainmal The animal.
	 *  @param compoundname The compound name.
	 */
	public void addAnimal(Animal ainmal, String compoundname);
	
	/**
	 *  Remove an animal from a compound.
	 *  @param ainmal The animal.
	 *  @param compoundname The compound name.
	 */
	public void deleteAnimal(String animalname, String compoundname);
}
