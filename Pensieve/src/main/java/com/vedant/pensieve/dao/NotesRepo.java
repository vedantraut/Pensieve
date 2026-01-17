package com.vedant.pensieve.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedant.pensieve.entities.Notes;

public interface NotesRepo extends JpaRepository<Notes, Integer> {

}
