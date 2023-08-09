package kr.com.greenart.sdmate.pjsdmate.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JoinExceptionHandler {
    @ExceptionHandler(JoinEmailException.class)
    public String handleJoinEmailException(JoinEmailException e, Model model) {
        model.addAttribute("joinEmailMsg", e.getMessage());
        return "join";
    }

    @ExceptionHandler(JoinIdException.class)
    public String handleJoinIdException(JoinIdException e, Model model) {
        model.addAttribute("joinIdMsg", e.getMessage());
        return "join";
    }

    @ExceptionHandler(JoinPhoneNumException.class)
    public String handleJoinPhoneNumException(JoinPhoneNumException e, Model model) {
        model.addAttribute("joinPhoneNumMsg", e.getMessage());
        return "join";
    }

}
