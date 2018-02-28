package com.example.demo.repository;


import com.example.demo.Model.AppUser;
import com.example.demo.Model.PledgedItem;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;

public interface AppUserRepository extends CrudRepository<AppUser, Long>{
    AppUser findByUsername(String username);
  //  HashSet<PledgedItem> findAppUserByItemList(HashSet<PledgedItem> pledgedItemHashSet);

}
