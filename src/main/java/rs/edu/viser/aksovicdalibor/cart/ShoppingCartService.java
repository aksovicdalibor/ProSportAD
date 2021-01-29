package rs.edu.viser.aksovicdalibor.cart;



import org.springframework.stereotype.Service;

import rs.edu.viser.aksovicdalibor.article.Article;

import java.util.Map;

@Service
public interface ShoppingCartService {
    void addArticle(Article article);
    void removeArticle(Article article);
    void clearArticles();
    Map<Article, Integer> articlesInCart();
    Double totalPrice();
    void cartCheckout();
}
