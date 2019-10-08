package com.zrh.sbls.router;

import com.zrh.sbls.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/5
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(HelloHandler helloHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),helloHandler::hello);
    }


}
