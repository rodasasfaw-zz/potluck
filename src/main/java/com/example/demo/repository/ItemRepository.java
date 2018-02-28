package com.example.demo.repository;

import com.example.demo.Model.PledgedItem;
import org.springframework.data.repository.CrudRepository;

public interface  ItemRepository extends CrudRepository<PledgedItem, Long> {

}
