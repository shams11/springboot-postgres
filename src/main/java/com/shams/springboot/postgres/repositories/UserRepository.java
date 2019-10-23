package com.shams.springboot.postgres.repositories;


import com.shams.springboot.postgres.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  List<UserEntity> findAll();
}
