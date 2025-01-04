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
        return repo.findById(id).orElse(null);
    }

    public EventsAndDetails addEventsAndDetails(EventsAndDetails eventsAndDetails) {
        return repo.save(eventsAndDetails);
    }
    
    public EventsAndDetails updateEventsAndDetails(String id1, EventsAndDetails eventsAndDetails) {
        String id = id1.toLowerCase();
        EventsAndDetails ed = (EventsAndDetails) repo.findByID(id);
        
        if(ed == null)
            return null;
        ed.setName(eventsAndDetails.getName());
        ed.setDescription(eventsAndDetails.getDescription());
        ed.setFirstYear(eventsAndDetails.getFirstYear());
        ed.setSecondYear(eventsAndDetails.getSecondYear());
        ed.setThirdYear(eventsAndDetails.getThirdYear());
        ed.setFourthYear(eventsAndDetails.getFourthYear());
        ed.setTotalParticipation(eventsAndDetails.getTotalParticipation());
        ed.setWinners(eventsAndDetails.getWinners());
        ed.setDate(eventsAndDetails.getDate());
        return repo.save(eventsAndDetails);
    }
    
    public EventsAndDetails deleteEventsAndDetails(String id1) {
        String id = id1.toLowerCase();
        EventsAndDetails ed = (EventsAndDetails) repo.findByID(id);
        
        if(ed == null)
            return null;
        repo.deleteById(id);
        return new EventsAndDetails("", "");
    }
    
//    public List<EventsAndDetails> searchEventsAndDetails(String keyword) {
//        return repo.searchEventsAndDetails(keyword);
//    }

    public List<EventsAndDetails> searchEventsAndDetails(String keyword) {
        return repo.searchEventsAndDetails(keyword);
    }
}
