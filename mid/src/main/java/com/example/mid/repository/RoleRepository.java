package com.example.mid.repository;

import com.example.mid.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM role u Where u.name=?1", nativeQuery = true)
    Role findRole(String name);
}
