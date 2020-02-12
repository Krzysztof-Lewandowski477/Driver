package pl.driver.article;


import java.util.List;

public interface ArticleService {
    Article getOne(Long id);

    Article getArticleOfTheWeek();

    List<Article> getAllArticles();

    List<Article> getArticlesUnreadByUser(Long id);

    void saveArticle(Article article);

    void deleteArticle(Long id);

    List<Article> findLimitedArticles(Integer startIndex, Integer amount);

    List<Article> findArticlesByTitle(String name);

    List<Article> findArticlesContaining(String content);
}
