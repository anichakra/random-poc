package me.anichakra.poc.ruleservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.ruleservice.entites.Student;

@Repository
public interface StudentManagementDao extends CrudRepository<Student, Integer> {

}
