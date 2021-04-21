package check;

import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		List<IArticle> as = Article.createArticles();
		
		as = makeArticlesFraudResistant(as);
		
		Article.checkArticles(as);
		
		double sum = 0;
		for(IArticle a: as)
		{
			sum += a.getPrice();
		}
		
		System.out.println("Your order costs: "+sum);
	}
	
	public static List<IArticle> makeArticlesFraudResistant(List<IArticle> as)
	{
		// todo: implement logic to protect articles from modification
		
		return as;
	}
}
