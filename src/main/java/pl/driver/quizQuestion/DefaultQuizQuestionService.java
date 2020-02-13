package pl.driver.quizQuestion;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultQuizQuestionService implements QuizQuestionService {

    private final QuizQuestionRepository quizQuestionRepository;

    public DefaultQuizQuestionService(QuizQuestionRepository quizQuestionRepository) {
        this.quizQuestionRepository = quizQuestionRepository;
    }

    @Override
    public List<QuizQuestion> getAll() {
        return quizQuestionRepository.findAll();
    }

    @Override
    public QuizQuestion getOne(Long id) {
        return quizQuestionRepository.getOne(id);
    }

    @Override
    public void saveQuizQuestion(QuizQuestion quizQuestion){
        quizQuestionRepository.save(quizQuestion);
    }

    @Override
    public void deleteQuizQuestion(Long id){
        quizQuestionRepository.deleteById(id);
    }

    @Override
    public List<QuizQuestion> getLimitedQuizQuestion(Integer startIndex, Integer amount){
        return quizQuestionRepository.findLimitedQuizQuestions(startIndex, amount);
    }
}
