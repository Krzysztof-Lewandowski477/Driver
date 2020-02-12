package pl.driver.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article getByIsAdviceOfTheWeekTrue();

    Article findTop1ByCreatedBeforeOrderByCreatedDesc(LocalDateTime now);

    @Query(value = "SELECT A.id, A.created, A.is_advice_of_the_week, A.content, A.title, A.has_quiz, A.likes, A.shares, A.updated, A.visual_content" +
            "FROM users_read UR JOIN articles A on UR.read_id = A.id WHERE UR.user_id = :id ;", nativeQuery = true)
    List<Article> findArticlesReadByUser(@Param("id") Long id);

    @Query(value = "SELECT * FROM articles LIMIT ?1, ?2 ;", nativeQuery = true)
    List<Article> findLimitedArticles(Integer startIndex, Integer amount);


    List<Article> findAllByTitleContaining(String title);

    List<Article> findAllByTitleAndContentContaining(String content1, String content2);
}
