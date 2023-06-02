package com.spring.project.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.project.spring.entities.TypeAchat;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAchatRepository extends JpaRepository<TypeAchat,Integer>{

        }

