package pl.driver.score;

import org.springframework.stereotype.Service;
import pl.driver.user.UserService;

@Service
public class DefaultScoreService implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final UserService userService;

    public DefaultScoreService(ScoreRepository scoreRepository, UserService userService) {
        this.scoreRepository = scoreRepository;
        this.userService = userService;
    }

    @Override
    public Integer getScoreForUser() {
        return scoreRepository.getByUserId(userService.getUserId()).get().getScore();
    }

}
