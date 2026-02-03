package ru.netology.HW2_Authorization_Service.service;

import org.springframework.stereotype.Service;
import ru.netology.HW2_Authorization_Service.exceptions.InvalidCredentials;
import ru.netology.HW2_Authorization_Service.exceptions.UnauthorizedUser;
import ru.netology.HW2_Authorization_Service.model.Authorities;
import ru.netology.HW2_Authorization_Service.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
