package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.PreQuizMapper;
import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class QuizCRUDService {
    @Autowired
    QuizMapper quizMapper;

    @Autowired
    PreQuizMapper preQuizMapper;


    public void quizUpdate(int quizId,
                           Model model) {
        List<Quiz> quizList = quizMapper.selectQuizAllByQuizId(quizId);
        Quiz quiz = quizList.get(0);
        QuizUpdateReq quizUpdateReq = new QuizUpdateReq();
        quizUpdateReq.setQuizId(quiz.getQuizId());
        quizUpdateReq.setQuizQuestionSent(quiz.getQuizQuestionSent());
        quizUpdateReq.setQuizRightOrBad(quiz.getQuizRightOrBad());
        quizUpdateReq.setQuizCommentary(quiz.getQuizCommentary());
        quizUpdateReq.setQuizCategory(quiz.getQuizCategory());
        quizUpdateReq.setQuizAuthor(quiz.getQuizAuthor());

        model.addAttribute("QuizList", quizUpdateReq);
        model.addAttribute("QuizId", quizId);

    }

    public void quizDelete(int quizId,
                           Model model) {
        List<Quiz> quizList = quizMapper.selectQuizAllByQuizId(quizId);
        Quiz quiz = quizList.get(0);

        QuizUpdateReq quizUpdateReq = new QuizUpdateReq();
        quizUpdateReq.setQuizId(quiz.getQuizId());
        quizUpdateReq.setQuizQuestionSent(quiz.getQuizQuestionSent());
        quizUpdateReq.setQuizRightOrBad(quiz.getQuizRightOrBad());
        quizUpdateReq.setQuizCommentary(quiz.getQuizCommentary());
        quizUpdateReq.setQuizCategory(quiz.getQuizCategory());
        quizUpdateReq.setQuizAuthor(quiz.getQuizAuthor());

        model.addAttribute("QuizList", quizUpdateReq);
        model.addAttribute("QuizId", quizId);
    }
    public void doQuizUpdate(QuizUpdateReq quizUpdateReq) {
        quizMapper.update(quizUpdateReq);
    }

    public void doQuizDelete(QuizUpdateReq quizUpdateReq) {
        quizMapper.delete(quizUpdateReq);
    }

    public void addQuizCategory(String quizCategory) {
        quizMapper.addQuizCategory(quizCategory);
    }

}
