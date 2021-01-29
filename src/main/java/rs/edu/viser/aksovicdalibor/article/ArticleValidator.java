package rs.edu.viser.aksovicdalibor.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArticleValidator implements Validator {
	private final ArticleService articleService;
	private Boolean newArticle = true;

	@Autowired
    public ArticleValidator(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Article.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Article article = (Article) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.not_empty");

   
        if (article.getName().length() <= 5) {
            errors.rejectValue("name", "article.error.name.less_5");
        }
        if (article.getName().length() > 50) {
            errors.rejectValue("name", "article.error.name.over_50");
        }
        if(newArticle) {
            if (articleService.findByName(article.getName()) != null) {
                errors.rejectValue("name", "article.error.duplicated.name");
            }
        }
    }
    
    public void setNewArticle(Boolean newArticle) {
    	this.newArticle = newArticle;
    }
}
