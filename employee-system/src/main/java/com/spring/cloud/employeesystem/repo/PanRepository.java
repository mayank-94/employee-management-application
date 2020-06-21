package com.spring.cloud.employeesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cloud.employeesystem.entity.Pan;

@Repository
@Transactional
public interface PanRepository extends JpaRepository<Pan, Integer> {

}
