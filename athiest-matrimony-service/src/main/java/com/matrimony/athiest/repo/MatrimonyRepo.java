package com.matrimony.athiest.repo;

import com.matrimony.athiest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrimonyRepo extends JpaRepository<UserEntity, String> {

}
