package partprices;

public interface IPart 
{
	public String getName();
	public double getPrice();
	
	public void addChild(IPart child);
	public IPart getChild(int idx);
	
	public void accept(IVisitor visitor);
}
