package com.matrimony.athiest.repo;

import com.matrimony.athiest.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetailEntity, String> {

}
