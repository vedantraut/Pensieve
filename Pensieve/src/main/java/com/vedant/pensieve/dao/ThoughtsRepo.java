package com.vedant.pensieve.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedant.pensieve.entities.Thoughts;

public interface ThoughtsRepo extends JpaRepository<Thoughts, Integer> {

}
