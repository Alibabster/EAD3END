package com.example.mid.repository;

import com.example.mid.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query(value = "SELECT * FROM Service n WHERE n.id=?1", nativeQuery = true)
    Service findByIds(Long id);

}
