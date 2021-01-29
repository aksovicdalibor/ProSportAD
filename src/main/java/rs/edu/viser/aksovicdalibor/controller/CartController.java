package rs.edu.viser.aksovicdalibor.controller;



import rs.edu.viser.aksovicdalibor.article.Article;
import rs.edu.viser.aksovicdalibor.article.ArticleService;
import rs.edu.viser.aksovicdalibor.cart.ShoppingCartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final ShoppingCartService shoppingCartService;
    private final ArticleService articleService;
    private boolean myFlag;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService, ArticleService articleService) {
        this.shoppingCartService = shoppingCartService;
        this.articleService = articleService;
        this.myFlag=false;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("articles", shoppingCartService.articlesInCart());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());
        model.addAttribute("done", myFlag);

        this.myFlag=false;
        
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addArticleToCart(@PathVariable("id") long id){
        Article article = articleService.findById(id);
        if (article != null){
            shoppingCartService.addArticle(article);
            logger.debug(String.format("article with id: %s added to shopping cart.", id));
        }
        return "redirect:/home";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeArticleFromCart(@PathVariable("id") long id){
        Article article = articleService.findById(id);
        if (article != null){
            shoppingCartService.removeArticle(article);
            logger.debug(String.format("article with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearArticlesInCart(Model model){
        shoppingCartService.clearArticles();

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(Model model){
        shoppingCartService.cartCheckout();
        this.myFlag=true;
        

        return "redirect:/cart";
    }
}

