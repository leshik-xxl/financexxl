package ua.leshik.financexxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.leshik.financexxl.model.User;
import ua.leshik.financexxl.service.UserService;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest){
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getUsername());
        userService.saveUser(user);
        return "registration_OK";
    }
}
