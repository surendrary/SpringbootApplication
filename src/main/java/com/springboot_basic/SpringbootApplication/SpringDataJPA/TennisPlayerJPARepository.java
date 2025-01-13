package com.springboot_basic.SpringbootApplication.SpringDataJPA;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TennisPlayerJPARepository extends JpaRepository<Player, Integer> {

    public List<Player> findByNationality(String nationality);


    public List<Player> findByIdGreaterThan(int Id);
}
