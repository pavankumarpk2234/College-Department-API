/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workgroup.ppk.cse.model.EventsAndDetails;
import workgroup.ppk.cse.service.EventsAndDetailsService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class EventsAndDetailsController {
    
    @Autowired
    private EventsAndDetailsService service;
    
    // http://localhost:8080/api/Events
    @GetMapping("/Events")
    public List<EventsAndDetails> getAllDepartmentNews(){
        return service.getAllEventsAndDetails();
    }
    
//    http://localhost:8080/api/EventsAndDetails/event1
    @GetMapping("/EventsAndDetails/{id}")
    public ResponseEntity<EventsAndDetails> getEventsAndDetails(@PathVariable String id){
        
        EventsAndDetails ed = service.getEventsAndDetailsById(id);
        
        if(ed != null)
            return new ResponseEntity<>(ed, HttpStatus.OK); 
        else
            return new ResponseEntity<>(new EventsAndDetails("Error", "No data found with "+id), HttpStatus.NOT_FOUND);
    }
    
    //    http://localhost:8080/api/EventsAndDetails
    @PostMapping("/EventsAndDetails")
    public ResponseEntity<?> addEventsAndDetails(@RequestBody EventsAndDetails eventsAndDetails){
            service.addEventsAndDetails(eventsAndDetails);
            return null;
    }
    
    //    http://localhost:8080/api/DepartmentNews/event1
    @PutMapping("/EventsAndDetails/{id}")
    public ResponseEntity<EventsAndDetails> updateEventsAndDetails(@PathVariable String id, @RequestBody EventsAndDetails eventsAndDetails){
        EventsAndDetails ed = null;
        ed = service.updateEventsAndDetails(id, eventsAndDetails);
//        System.out.println(dn.toString());
        if(ed != null)
            return new ResponseEntity<>(new EventsAndDetails("Success", "Data has been Updated"), HttpStatus.OK);
        else
            return new ResponseEntity<>(new EventsAndDetails("Error", "No data found with "+id), HttpStatus.BAD_REQUEST);
    }
    
    //    http://localhost:8080/api/EventsAndDetails/event1
    @DeleteMapping("/EventsAndDetails/{id}")
    public ResponseEntity<EventsAndDetails> deleteEventsAndDetails(@PathVariable String id){
        EventsAndDetails ed = service.deleteEventsAndDetails(id);
        if(ed != null){
//            service.deleteEventsAndDetails(id);
            return new ResponseEntity<>(new EventsAndDetails("Success", "Data has been deleted"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new EventsAndDetails("Error", "No data found with "+id), HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/EventsAndDetails/search")
    public ResponseEntity<List<EventsAndDetails>> searchEventsAndDetails(@RequestParam String keyword){
        List<EventsAndDetails> led = service.searchEventsAndDetails(keyword);
        return new ResponseEntity<>(led, HttpStatus.OK);
    }
}
