package rs.edu.viser.aksovicdalibor.article;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(long id);
    Article findByName(String name);
    List<Article> findAllByOrderByIdAsc();
}
