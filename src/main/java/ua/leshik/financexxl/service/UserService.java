package ua.leshik.financexxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.leshik.financexxl.model.User;
import ua.leshik.financexxl.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUserNameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
