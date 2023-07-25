package com.example.Universityeventmanagement.service;

import com.example.Universityeventmanagement.model.Event;
import com.example.Universityeventmanagement.model.Student;
import com.example.Universityeventmanagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo iEventRepo;
    public List<Event> getAllEvents() {
        return iEventRepo.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> searchedStudent = iEventRepo.findById(id);
        return searchedStudent.get();
    }

    public void createEvent(Event event) {
        iEventRepo.save(event);
    }

    public void createListEvents(List<Event> events) {
        iEventRepo.saveAll(events);
    }

    public String updateEventLocation(Long id, String location) {
        if(iEventRepo.existsById(id)){
            Event event = getEventById(id);
            event.setEventLocation(location);
            return "location has been updated";
        }
        return "id does not exist to update location";
    }

    public String deleteEventById(Long id) {
        if(iEventRepo.existsById(id)){
            iEventRepo.deleteById(id);
            return "event deleted";
        }
        return "id does not exists";
    }
}
