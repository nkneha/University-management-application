package com.example.Universityeventmanagement.repository;

import com.example.Universityeventmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Long> {
}
