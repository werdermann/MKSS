package zoo;

import java.util.ArrayList;
import java.util.List;

public class Compound
{
	private String name;
	
	private double size;
	
	private List<Animal> animals;
	
	public Compound(String name, double size)
	{
		this(name, size, null);
	}
	
	public Compound(String name, double size, List<Animal> animals)
	{
		this.name = name;
		this.size = size;
		this.animals = animals!=null? animals: new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal animal)
	{
		animals.add(animal);
	}
	
	public void removeAnimal(Animal animal)
	{
		animals.remove(animal);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getSize()
	{
		return size;
	}

	public void setSize(double size)
	{
		this.size = size;
	}

	public List<Animal> getAnimals()
	{
		return animals;
	}

	public void setAnimals(List<Animal> animals)
	{
		this.animals = animals;
	}
	
}
