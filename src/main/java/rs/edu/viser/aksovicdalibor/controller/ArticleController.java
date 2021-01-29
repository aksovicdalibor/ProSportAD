package rs.edu.viser.aksovicdalibor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import rs.edu.viser.aksovicdalibor.article.Article;
import rs.edu.viser.aksovicdalibor.article.ArticleService;
import rs.edu.viser.aksovicdalibor.article.ArticleValidator;

@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleService articleService;
    private final ArticleValidator articleValidator;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleValidator articleValidator) {
        this.articleService = articleService;
        this.articleValidator = articleValidator;
    }

    @GetMapping("/article/new")
    public String newArticle(Model model) {
        model.addAttribute("articleForm", new Article());
        model.addAttribute("method", "new");
        return "article";
    }

    @PostMapping("/article/new")
    public String newProduct(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model) {
    	articleValidator.setNewArticle(true);
    	articleValidator.validate(articleForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "article";
        }
        articleService.save(articleForm);
        logger.debug(String.format("Article with id: %s successfully created.", articleForm.getId()));

        return "redirect:/home";
    }

    @GetMapping("/article/edit/{id}")
    public String editArticle(@PathVariable("id") long articleId, Model model){
        Article article = articleService.findById(articleId);
        if (article != null){
            model.addAttribute("articleForm", article);
            model.addAttribute("method", "edit");
            return "article";
        }else {
            return "error/404";
        }
    }

    @PostMapping("/article/edit/{id}")
    public String editArticle(@PathVariable("id") long articleId, @ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model){
    	articleValidator.setNewArticle(false);
    	articleValidator.validate(articleForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "article";
        }
        articleService.edit(articleId, articleForm);
        logger.debug(String.format("Product with id: %s has been successfully edited.", articleId));

        return "redirect:/home";
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") long articleId){
        Article article = articleService.findById(articleId);
        if (article != null){
        	articleService.delete(articleId);
           logger.debug(String.format("Article with id: %s successfully deleted.", article.getId()));
           return "redirect:/home";
        }else {
            return "error/404";
        }
    }
}
