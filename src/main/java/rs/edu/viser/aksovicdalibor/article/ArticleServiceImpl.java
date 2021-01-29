package rs.edu.viser.aksovicdalibor.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void edit(long id, Article newArticle) {
        Article selectedArticle = articleRepository.getOne(id);
        selectedArticle.setName(newArticle.getName());
        selectedArticle.setImageUrl(newArticle.getImageUrl());
        selectedArticle.setDescription(newArticle.getDescription());
        selectedArticle.setPrice(newArticle.getPrice());
        save(newArticle);
    }

    @Override
    public void delete(long id) {
        articleRepository.delete(findById(id));
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id);
    }

    public Article findByName(String name) {
    	return articleRepository.findByName(name);
    }
    
    @Override
    public List<Article> findAllByOrderByIdAsc() {
        return articleRepository.findAllByOrderByIdAsc();
    }
}
