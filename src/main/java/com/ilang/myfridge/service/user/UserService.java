package com.ilang.myfridge.service.user;

import com.ilang.myfridge.model.user.User;
import com.ilang.myfridge.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User saveUser(String uuid) {
        return userRepository.save(User.from(uuid));
    }
}
