package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.PreQuizMapper;
import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class PreQuizService {

    @Autowired
    PreQuizMapper preQuizMapper;

    @Autowired
    QuizMapper quizMapper;

    public void addGoodService(int quizId) {
       Quiz quiz = preQuizMapper.selectPreQuizById(quizId);
       int quizGood = quiz.getQuizGood() + 1;
       preQuizMapper.addGood(quizGood, quizId);
    }

    public void selectPreQuiz(Model model) {
        model.addAttribute("preQuiz", preQuizMapper.selectPreQuiz());
    }

    public void insertPreQuizToQuiz(int quizId){
        quizMapper.QUIZ_SYNC();
        Quiz quiz = preQuizMapper.selectPreQuizById(quizId);
        quizMapper.preQuizToQuiz(quiz);
    }

    public void quizPreInsert(@ModelAttribute Quiz quiz,
                              String username) {
        preQuizMapper.PREQUIZ_SYNC();
        preQuizMapper.insertPreQuiz(quiz, username);
    }

    public void deletePreQuiz(int quizId) {
        preQuizMapper.deletePreQuiz(quizId);
    }

    public void subMiss(Model model) {
        model.addAttribute("SubMiss", "登録に失敗しました");
    }
}


