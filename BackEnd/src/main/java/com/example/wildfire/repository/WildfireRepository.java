package com.example.wildfire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.wildfire.entity.*;

@CrossOrigin
@Repository
public interface WildfireRepository extends JpaRepository<Wildfire, Long>{

}
