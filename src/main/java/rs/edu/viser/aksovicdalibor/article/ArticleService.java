package rs.edu.viser.aksovicdalibor.article;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    void save(Article article);
    void edit(long id, Article newArticle);
    void delete(long id);
    Article findById(long id);
    Article findByName(String name);
    List<Article> findAllByOrderByIdAsc();
}