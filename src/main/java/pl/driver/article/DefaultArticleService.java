package pl.driver.article;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.driver.quizQuestion.QuizQuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultArticleService implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper mapper;
    private final QuizQuestionRepository quizQuestionRepository;

    public DefaultArticleService(ArticleRepository articleRepository, ModelMapper modelMapper, QuizQuestionRepository quizQuestionRepository) {
        this.articleRepository = articleRepository;
        this.mapper = modelMapper;
        this.quizQuestionRepository = quizQuestionRepository;
    }

    @Override
    public Article getOne(Long id) {
        Article article = articleRepository.getOne(id);
        if(article.getHasQuiz()){
            article.setQuizQuestions(article.getQuizQuestions().stream().map(q->quizQuestionRepository.getOne(q.getId())).collect(Collectors.toList()));
        }
        return article;
    }

    @Override
    public Article getArticleOfTheWeek() {
        return Optional.ofNullable(articleRepository.getByIsAdviceOfTheWeekTrue())
                .map(a -> mapper.map(a, Article.class))
                .orElse(articleRepository.findTop1ByCreatedBeforeOrderByCreatedDesc(LocalDateTime.now()));

    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticlesUnreadByUser(Long id) {
        List<Article> all = articleRepository.findAll();
        all.removeAll(articleRepository.findArticlesReadByUser(id));
        return all;
    }

    @Override
    public void saveArticle(Article article) {
        if (article.getIsAdviceOfTheWeek()){
            Article ofTheWeek = getArticleOfTheWeek();
            ofTheWeek.setIsAdviceOfTheWeek(Boolean.FALSE);
            articleRepository.save(ofTheWeek);
        }
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> findLimitedArticles(Integer startIndex, Integer amount){
        return articleRepository.findLimitedArticles(startIndex, amount);
    }

    @Override
    public List<Article> findArticlesByTitle(String title){
        return articleRepository.findAllByTitleContaining(title);
    }

    @Override
    public List<Article> findArticlesContaining(String content){
        content.replaceAll(" ", "%");
       // articleRepository.finCon
        return null;
    }


}
