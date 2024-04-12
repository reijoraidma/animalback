package com.lostfound.animalback.business.register;

import com.lostfound.animalback.business.register.dto.UserRequest;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserMapper;
import com.lostfound.animalback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;




    public void registerUser(UserRequest userRequest) {
        User user = createAndSaveUser(userRequest);
        // lisa profiili info
        // loo uus profiili objekt
        // lisa külge vajalik info
        // salvesta profiil

    }

    private User createAndSaveUser(UserRequest userRequest) {
        User user = createUser(userRequest);
        // todo: enne kui salvestad, pane leitud roll userile külge
        userRepository.save(user);
        return user;
    }

    private User createUser(UserRequest userRequest) {
        // todo: otsi ülesse roll "customer", ID 2 abil
        User user = userMapper.toUser(userRequest);
        return user;
    }
}
