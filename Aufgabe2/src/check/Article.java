package check;

import java.util.ArrayList;
import java.util.List;

final public class Article implements IArticle
{
	private String name;
	private double price;

	public Article(String name, double price) 
	{
		this.name = name;
		this.price = price;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public static final void checkArticles(List<IArticle> as)
	{
		for(IArticle a: as)
		{
			try
			{
				a.setPrice(0.01);
			}
			catch(Exception e)
			{
				System.out.println("Damn, cheating did not work");
			}
		}
	}
	
	public static final List<IArticle> createArticles()
	{
		List<IArticle> as = new ArrayList<>();
		as.add(new Article("Banana", 0.99));
		as.add(new Article("Milk", 0.60));
		as.add(new Article("T-Shirt", 9.99));
		return as;
	}
}
