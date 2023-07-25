package com.example.Universityeventmanagement.controller;

import com.example.Universityeventmanagement.model.Event;
import com.example.Universityeventmanagement.model.Student;
import com.example.Universityeventmanagement.service.EventService;
import com.example.Universityeventmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {
    @Autowired
    StudentService studentService;

    @Autowired
    EventService eventService;
    //API for students
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("student/{id}/id")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudents(id);
    }
    @PostMapping("student")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
    @PostMapping("students")
    public void createListStudent(@RequestBody List<Student> students){
        studentService.createListStudent(students);
    }
    @PutMapping("student/id/age/{id}")
    public String updateStudentAge(@PathVariable Long id,@RequestParam Integer age){
        return studentService.updateStudentAge(id,age);
    }
    @DeleteMapping("remove/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    // API for Event

    @GetMapping("events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("event/{id}/id")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }
    @PostMapping("event")
    public void createEvent(@RequestBody Event event){
        eventService.createEvent(event);
    }
    @PostMapping("events")
    public void createListEvents(@RequestBody List<Event> events){
        eventService.createListEvents(events);
    }
    @PutMapping("student/id/location/{id}")
    public String updateEventLocation(@PathVariable Long id,@RequestParam String location){
        return eventService.updateEventLocation(id,location);
    }
    @DeleteMapping("remove/event/{id}")
    public String deleteEventById(@PathVariable Long id){
        return eventService.deleteEventById(id);
    }


}
