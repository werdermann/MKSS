package partprices;


public class BasePart implements IPart
{
	protected String name;
	protected double price;
	
	public BasePart(String name, double price) 
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void addChild(IPart child)
	{
		throw new RuntimeException();
	}
	
	public IPart getChild(int idx)
	{
		throw new RuntimeException();
	}
	
	public void accept(IVisitor visitor)
	{
		visitor.visit(this);
	}
	
	public String toString() 
	{
		return getName();
	}
}
