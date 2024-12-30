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
import workgroup.ppk.cse.model.FacultyDetails;
import workgroup.ppk.cse.service.FacultyDetailsService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class FacultyDetailsController {
    
    @Autowired
    private FacultyDetailsService service;
    
    
//    http://localhost:8080/api/FacultyDetails
    @GetMapping("/FacultyDetails")
    public List<FacultyDetails> getAllFacultyDetails(){
        return service.getAllFacultyDetails();
    }
    
    @GetMapping("/FacultyDetails/{id}")
    public ResponseEntity<FacultyDetails> getFacultyDetails(@PathVariable int id){
        
        FacultyDetails product = service.getFacultyDetailsById(id);
        
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK); 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/FacultyDetails/search")
    public ResponseEntity<List<FacultyDetails>> searchFacultyDetails(@RequestParam String keyword){
        List<FacultyDetails> facultydetails = service.searchFacultyDetails(keyword);
        return new ResponseEntity<>(facultydetails, HttpStatus.OK);
    }
}
