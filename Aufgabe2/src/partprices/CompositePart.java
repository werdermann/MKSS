package partprices;

import java.util.ArrayList;
import java.util.List;

public class CompositePart extends BasePart
{
	protected List<IPart> children;
	
	public CompositePart(String name, double price) 
	{
		super(name, price);
	}
	
	public void addChild(IPart child)
	{
		if(children==null)
			children = new ArrayList<>();
		children.add(child);
	}
	
	public IPart getChild(int idx)
	{
		return children!=null? children.get(idx): null;
	}
}
