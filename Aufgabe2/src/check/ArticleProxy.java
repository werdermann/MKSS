package check;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ArticleProxy implements InvocationHandler {

    private final IArticle subject;

    ArticleProxy(IArticle subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("setPrice")) throw new Exception();
        return method.invoke(subject, args);
    }

    public static List<IArticle> makeArticlesFraudResistant(List<IArticle> as)
    {
        List<IArticle> proxyList = new ArrayList<>();
        for(IArticle article : as) {
            IArticle proxyArticle = (IArticle) Proxy.newProxyInstance(
                    article.getClass().getClassLoader(),
                    article.getClass().getInterfaces(),
                    new ArticleProxy(article));

            proxyList.add(proxyArticle);
        }

        return proxyList;
    }
}
