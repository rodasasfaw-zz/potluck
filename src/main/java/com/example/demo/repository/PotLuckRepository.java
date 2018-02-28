package com.example.demo.repository;

import com.example.demo.Model.PotLuck;
import org.springframework.data.repository.CrudRepository;

public interface PotLuckRepository extends CrudRepository<PotLuck, Long> {
}
