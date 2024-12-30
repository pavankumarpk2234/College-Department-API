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
import workgroup.ppk.cse.model.StudentDetails;
import workgroup.ppk.cse.service.StudentDetailsService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class StudentDetailsController {
    
    @Autowired
    private StudentDetailsService service;
    
//    http://localhost:8080/api/StudentDetails
    @GetMapping("/StudentDetails")
    public List<StudentDetails> getAllStudentDetails(){
        return service.getAllStudentDetails();
    }
    
    @GetMapping("/StudentDetails/{id}")
    public ResponseEntity<StudentDetails> getStudentDetails(@PathVariable int id){
        
        StudentDetails product = service.getStudentDetailsById(id);
        
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK); 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/StudentDetails/search")
    public ResponseEntity<List<StudentDetails>> searchStudentDetails(@RequestParam String keyword){
        List<StudentDetails> studentdetails = service.searchStudentDetails(keyword);
        return new ResponseEntity<>(studentdetails, HttpStatus.OK);
    }
}
