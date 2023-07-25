package com.example.Universityeventmanagement.repository;

import com.example.Universityeventmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepo extends JpaRepository<Event,Long> {
}
