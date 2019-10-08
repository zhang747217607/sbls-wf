package com.zrh.sbls.repository;

import com.zrh.sbls.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
public interface UserRepository extends ReactiveMongoRepository<User,Long> {
}
