package com.vedant.pensieve.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vedant.pensieve.entities.Thought;

public interface ThoughtRepo extends JpaRepository<Thought, Long> {

}
