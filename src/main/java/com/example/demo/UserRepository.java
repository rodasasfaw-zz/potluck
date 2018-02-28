package com.example.demo;

import com.example.demo.Model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long>{
    AppUser findByUsername(String username);
    AppUser findById(Long id);

}
