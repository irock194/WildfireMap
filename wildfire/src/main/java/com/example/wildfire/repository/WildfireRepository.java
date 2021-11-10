package com.example.wildfire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wildfire.entity.*;

@Repository
public interface WildfireRepository extends JpaRepository<Wildfire, Long>{

}
