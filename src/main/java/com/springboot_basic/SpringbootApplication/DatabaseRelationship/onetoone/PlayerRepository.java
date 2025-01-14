package com.springboot_basic.SpringbootApplication.DatabaseRelationship.onetoone;

import com.springboot_basic.SpringbootApplication.DatabaseRelationship.onetoone.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
