package com.matrimony.athiest.repo;

import com.matrimony.athiest.entity.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepo extends JpaRepository<AuthoritiesEntity, String> {
}
