package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// employee table jpa repo to perform various operation
public interface JpaRepoInterface extends JpaRepository<employee,Integer> {
    //
    @Query(value = "select u from employee u where u.date>=cast(:StartDate as date) and u.date<=cast(:EndDate as date)")
    public List<employee> ListOfEmployee(String StartDate,String EndDate);
}
