package pro.sky.exever.examiner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        return questionService.remove(question, answer);
    }
}
