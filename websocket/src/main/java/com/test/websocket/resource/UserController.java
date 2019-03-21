package com.test.websocket.resource;

import com.test.websocket.model.User;
import com.test.websocket.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UserController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/user")
    @SendTo("/notification-topic3/user")
    public UserResponse getUser(User user) {
       // System.out.println("testing "+ user.getName());
        return new UserResponse("Hi " + user.getName());
    }

//    @MessageExceptionHandler
//    public String handleException(Throwable exception) {
//        messagingTemplate.convertAndSend("/errors", exception.getMessage());
//        return exception.getMessage();
//    }
}