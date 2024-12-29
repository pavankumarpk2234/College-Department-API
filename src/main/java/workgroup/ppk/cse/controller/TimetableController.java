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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workgroup.ppk.cse.model.Timetable;
import workgroup.ppk.cse.service.TimetableService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class TimetableController {
    
    @Autowired
    private TimetableService service;
    
    @GetMapping("/Timetable")
    public List<Timetable> getAllTimetable(){
        return service.getAllTimetable();
    }
    
    @GetMapping("/Timetable/{id}")
    public ResponseEntity<Timetable> getStudentDetails(@PathVariable int id){
        
        Timetable product = service.getTimetableById(id);
        
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK); 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/Timetable/search")
    public ResponseEntity<List<Timetable>> searchTimetable(@RequestParam String keyword){
        List<Timetable> timetable = service.searchTimetable(keyword);
        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }
}
