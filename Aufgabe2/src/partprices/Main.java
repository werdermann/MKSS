package partprices;

public class Main 
{
	public static void main(String[] args) 
	{
		CompositePart c1 = new CompositePart("c1", 1);
		c1.addChild(new BasePart("b1", 0.1));
		c1.addChild(new BasePart("b2", 0.2));
		c1.addChild(new BasePart("b3", 0.3));
		CompositePart c2 = new CompositePart("c2", 2);
		c2.addChild(c1);
		c2.addChild(new BasePart("b4", 0.4));
		
		// create and use a price visitor
		PriceVisitor priceVisitor = new PriceVisitor();
		priceVisitor.visit(c1);
		// create and use a name visitor
	}
}
