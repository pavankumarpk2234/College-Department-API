/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.EventsAndDetails;
import workgroup.ppk.cse.repo.EventsAndDetailsRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class EventsAndDetailsService {
    
    @Autowired
    private EventsAndDetailsRepo repo;

    public List<EventsAndDetails> getAllEventsAndDetails() {
        return repo.findAll();
    }

    public EventsAndDetails getEventsAndDetailsById(String id) {
        return repo.findById(id).orElse(new EventsAndDetails("Error", "No data found with "+id));
    }

//    public List<EventsAndDetails> searchEventsAndDetails(String keyword) {
//        return repo.searchEventsAndDetails(keyword);
//    }

    public List<EventsAndDetails> searchEventsAndDetails(String keyword) {
        return repo.searchEventsAndDetails(keyword);
    }
}
