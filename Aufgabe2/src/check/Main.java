package check;

import java.util.List;

import static check.ArticleProxy.makeArticlesFraudResistant;

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

}
