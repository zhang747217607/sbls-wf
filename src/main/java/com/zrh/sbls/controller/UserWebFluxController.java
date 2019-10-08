package com.zrh.sbls.controller;

import com.zrh.sbls.domain.User;
import com.zrh.sbls.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author zhangrenhua
 */
@Controller
@RequestMapping(value = "/user")
public class UserWebFluxController {

    @Autowired
    private UserHandler userHandler;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono<User> findCityById(@PathVariable("id") Long id) {
        return userHandler.findById(id);
    }

    @GetMapping()
    @ResponseBody
    public Flux<User> findAllUser() {
        return userHandler.findAll();
    }

    @PostMapping()
    @ResponseBody
    public Mono<User> saveCity(@RequestBody User user) {
        return userHandler.save(user);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return userHandler.deleteById(id);
    }



    @GetMapping(value = "/pageList")
    public String pageList(final Model model){
        Flux<User> list = userHandler.findAll();
        model.addAttribute("userList",list);
        return "userList";

    }

    @GetMapping(value = "/getId")
    public String getUsername(@RequestParam Long id, final Model model){
        Mono<User> userMono = userHandler.findById(id);
        model.addAttribute("user",userMono);
        return "user";

    }
}