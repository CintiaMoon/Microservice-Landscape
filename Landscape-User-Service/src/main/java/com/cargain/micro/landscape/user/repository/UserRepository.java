package com.cargain.micro.landscape.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cargain.micro.landscape.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);

}
