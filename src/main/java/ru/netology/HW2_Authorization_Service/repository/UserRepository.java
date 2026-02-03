package ru.netology.HW2_Authorization_Service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.HW2_Authorization_Service.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {

    // Простой базовый функционал: логин + пароль → список прав
    private final Map<String, String> users = new HashMap<>();
    private final Map<String, List<Authorities>> userAuthorities = new HashMap<>();

    public UserRepository() {
        // Данные для теста: два пользователя с разными правами
        users.put("user1", "pass1");
        users.put("admin", "adminpass");

        userAuthorities.put("user1", List.of(Authorities.READ));
        userAuthorities.put("admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        String storedPassword = users.get(user);
        if (storedPassword == null || !storedPassword.equals(password)) {
            // Пользователя не существует или пароль неверный — возвращаем пустой список прав
            return Collections.emptyList();
        }
        return userAuthorities.getOrDefault(user, Collections.emptyList());
    }
}
