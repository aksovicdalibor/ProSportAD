package rs.edu.viser.aksovicdalibor.cart;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import rs.edu.viser.aksovicdalibor.article.Article;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
    private Map<Article, Integer> cart = new LinkedHashMap<>();

    @Override
    public void addArticle(Article article) {
        if (cart.containsKey(article)){
            cart.replace(article, cart.get(article) + 1);
        }else{
            cart.put(article, 1);
        }
    }

    @Override
    public void removeArticle(Article article) {
        if (cart.containsKey(article)) {
            if (cart.get(article) > 1)
                cart.replace(article, cart.get(article) - 1);
            else if (cart.get(article) == 1) {
                cart.remove(article);
            }
        }
    }

    @Override
    public void clearArticles() {
        cart.clear();
    }

    @Override
    public Map<Article, Integer> articlesInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public Double totalPrice() {
    	Double total = 0.0;
    	
    	for(Map.Entry<Article, Integer> entry : cart.entrySet()){
    		total += entry.getKey().getPrice()*entry.getValue();
    	}
        return total;
    }

    @Override
    public void cartCheckout() {
        cart.clear();
    }
}

