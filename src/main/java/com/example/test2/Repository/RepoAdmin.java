package com.example.test2.Repository;

import com.example.test2.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAdmin extends JpaRepository<Admin,Integer> {
}
