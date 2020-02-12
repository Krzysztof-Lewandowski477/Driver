package pl.driver.article;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.driver.quizQuestion.QuizQuestion;
import pl.driver.tag.TagService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper mapper;
    private final TagService tagService;

    public ArticleController(ArticleService articleService, ModelMapper mapper, TagService tagService) {
        this.articleService = articleService;
        this.mapper = mapper;
        this.tagService = tagService;
    }

    @Secured("ROLE_USER")
    @GetMapping("/all")
    public List<Article> allArticles() {
        return articleService.getAllArticles();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ArticleDto readArticle(Long id) {
        return mapper.map(articleService.getOne(id), ArticleDto.class);
    }

    //TODO change to ROLE_ADMIN EVERYWHERE!!!
    //@Secured("ROLE_ADMIN")
    @GetMapping("/add")
    public ArticleDto addArticle() {
        return new ArticleDto();
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public void saveArticle(@RequestBody ArticleDto articleDto) {

        Article article = mapper.map(articleDto, Article.class);
        if (articleDto.getHasQuiz()) {
            List<QuizQuestion> quizQuestions = new ArrayList<>();
            articleDto.getQuizQuestions().stream()
                    .forEach(q -> quizQuestions
                            .add(mapper.map(q, QuizQuestion.class)));
            article.setQuizQuestions(quizQuestions);
        }

        article.getTags().stream()
                .filter(t -> tagService.existById(t.getId()))
                .forEach(t -> t.setPopularity(t.getPopularity() + 1));

        article.setId(null);
        articleService.saveArticle(article);
    }

    @PutMapping("/update")
    public void updateArticle(@RequestBody @Valid ArticleDto articleDto) {
        articleService.saveArticle(mapper.map(articleDto, Article.class));
    }

    @DeleteMapping("/delete")
    public void deleteArticle(Long id) {
        articleService.deleteArticle(id);
    }

    @Secured("ROLE_USER")
    @GetMapping("/unreadByUser")
    public List<Article> articlesUnreadByUser(Long id) {
        return articleService.getArticlesUnreadByUser(id);
    }

    @Secured("ROLE_USER")
    @GetMapping("/get/limited")
    public List<ArticleDto> findLimitedArticles(Integer startIndex, Integer amount) {
        return articleService.findLimitedArticles(startIndex, amount)
                .stream()
                .map(a -> mapper.map(a, ArticleDto.class))
                .collect(Collectors.toList());
    }

    @Secured("ROLE_USER")
    @GetMapping("/of-the-week")
    public ArticleDto getArticleOfTheWeek() {
        return mapper.map(articleService.getArticleOfTheWeek(), ArticleDto.class);
    }

    @Secured("ROLE_USER")
    @GetMapping("/get/by-title")
    public List<ArticleDto> getArticlesByTitle(String title) {
        return articleService.findArticlesByTitle(title)
                .stream()
                .map(a -> mapper.map(a, ArticleDto.class))
                .collect(Collectors.toList());
    }


}
