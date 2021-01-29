package rs.edu.viser.aksovicdalibor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rs.edu.viser.aksovicdalibor.article.Article;
import rs.edu.viser.aksovicdalibor.article.ArticleService;

@Controller
public class HomeController {
	 private final ArticleService articleService;

	    @Autowired
	    public HomeController(ArticleService articleService) {
	        this.articleService = articleService;
	    }

	    @GetMapping(value = {"/","/index","/home"})
	    public String home(Model model){
	        model.addAttribute("articles", getAllArticles());
	        
	        Boolean isInEnglish = (LocaleContextHolder.getLocale().getDisplayLanguage()=="English")? true : false;
	        model.addAttribute("lang", isInEnglish);

	        return "home";
	    }

	    private List<Article> getAllArticles(){
	        return articleService.findAllByOrderByIdAsc();
	    }
	
}
