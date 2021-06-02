package zoo;

public class Animal
{
	private String name;
	
	private String type;
	
	private double age;

	public Animal(String name, String type, double age)
	{
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public double getAge()
	{
		return age;
	}

	public void setAge(double age)
	{
		this.age = age;
	}
}
