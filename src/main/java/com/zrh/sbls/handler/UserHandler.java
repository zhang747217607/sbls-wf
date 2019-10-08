package com.zrh.sbls.handler;

import com.zrh.sbls.domain.User;
import com.zrh.sbls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
@Component
public class UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> save(User user){
        return userRepository.save(user);
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Mono<Long> deleteById(Long id){
        userRepository.deleteById(id);
        return Mono.create(userMonoSink -> userMonoSink.success(id));
    }

}
