package com.cargain.micro.landscape.user.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.user.model.User;
import com.cargain.micro.landscape.user.repository.UserRepository;

@RestController
@RequestMapping("/user")
@RefreshScope //Used to refresh values retrieved from Config server
public class UserController {

    @Autowired
    UserRepository usersRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable("name") final String name) {
        return usersRepository.findByName(name);

    }

    @GetMapping("/{id}")
    public User getId(@PathVariable("id") final Integer id) {
        return usersRepository.findOne(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {


        User users = getId(id);
        users.setName(name);

        return usersRepository.save(users);
    }
    
    @PostMapping("/create")
    public User create(@Valid @RequestBody User user) {
      return usersRepository.save(user);
    }
   
}
