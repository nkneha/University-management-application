package com.example.Universityeventmanagement.service;

import com.example.Universityeventmanagement.model.Student;
import com.example.Universityeventmanagement.repository.IStudentRepo;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;
    public List<Student> getAllStudents() {
        return iStudentRepo.findAll();
    }
    public Student getStudents(Long id) {
        Optional<Student> searchedStudent = iStudentRepo.findById(id);
            return searchedStudent.get();

    }

    public void createStudent(Student student) {
         iStudentRepo.save(student);
    }

    public void createListStudent(List<Student> students) {
        iStudentRepo.saveAll(students);
    }


    public String updateStudentAge(Long id, Integer age) {

        if(iStudentRepo.existsById(id)){
            Student student= getStudents(id);
            student.setStudentAge(age);
            iStudentRepo.save(student);
            return "details updated";
        }
       return "id do not found";
    }

    public String deleteStudentById(Long id) {
        if(iStudentRepo.existsById(id)){
            iStudentRepo.deleteById(id);
            return "student deleted successfully!!!!";
        }
        return "Student does not exists";
    }
}
