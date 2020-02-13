package pl.driver.quizQuestion;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/quiz-question")
public class QuizQuestionController {

    private final QuizQuestionService quizQuestionService;
    private final ModelMapper mapper;

    public QuizQuestionController(QuizQuestionService quizQuestionService, ModelMapper mapper) {
        this.quizQuestionService = quizQuestionService;
        this.mapper = mapper;
    }

    @Secured("ROLE_USER")
    @GetMapping("/all")
    public List<QuizQuestionDto> allQuizQuestions() {
        return quizQuestionService.getAll().stream()
                .map(q -> mapper.map(q, QuizQuestionDto.class))
                .collect(Collectors.toList());
    }

    @Secured("ROLE_USER")
    @GetMapping("/get")
    public QuizQuestionDto getOne(Long id) {
        return mapper.map(quizQuestionService.getOne(id), QuizQuestionDto.class);
    }

    @Secured("ROLE_USER")
    @GetMapping("/add")
    public QuizQuestionDto addQuizQuestion() {
        return new QuizQuestionDto();
    }

    @Secured("ROLE_USER")
    @PostMapping("/add")
    public void saveQuizQuestion(@RequestBody QuizQuestionDto quizQuestionDto) {
        quizQuestionDto.setId(null);
        quizQuestionService.saveQuizQuestion(mapper.map(quizQuestionDto, QuizQuestion.class));
    }

    @Secured("ROLE_USER")
    @PutMapping("/update")
    public void updateQuizQuestion(@RequestBody QuizQuestionDto quizQuestionDto) {
        quizQuestionService.saveQuizQuestion(mapper.map(quizQuestionDto, QuizQuestion.class));
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/delete")
    public void deleteQuizQuestion(Long id) {
        quizQuestionService.deleteQuizQuestion(id);
    }

    @GetMapping("/get/limited")
    @Secured("ROLE_USER")
    public List<QuizQuestionDto> getLimitedQuizQuestions(Integer startIndex, Integer amount) {
        return quizQuestionService.getLimitedQuizQuestion(startIndex, amount)
                .stream()
                .map(q -> mapper.map(q, QuizQuestionDto.class))
                .collect(Collectors.toList());
    }


}
