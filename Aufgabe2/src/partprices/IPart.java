package partprices;

public interface IPart 
{
	String getName();
	double getPrice();
	
	void addChild(IPart child);
	IPart getChild(int idx);
	
	void accept(IVisitor visitor);
}
