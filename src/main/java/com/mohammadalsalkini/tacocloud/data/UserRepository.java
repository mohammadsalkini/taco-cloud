package com.mohammadalsalkini.tacocloud.data;

import com.mohammadalsalkini.tacocloud.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
