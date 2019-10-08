package com.zrh.sbls.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("Hello world!"));

    }
}
