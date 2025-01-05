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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workgroup.ppk.cse.model.FacultyAttendance;
import workgroup.ppk.cse.model.FacultyAttendanceComposite;
import workgroup.ppk.cse.service.FacultyAttendanceService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class FacultyAttendanceController {
    
    @Autowired
    private FacultyAttendanceService service;
    
//    http://localhost:8080/api/FacultyAttendance
    @GetMapping("/FacultyAttendance")
    public List<FacultyAttendance> getAllFacultyAttendance(){
        return service.getAllFacultyAttendance();
    }
    
    //    http://localhost:8080/api/FacultyAttendance/Parvathi
    @GetMapping("/FacultyAttendance/{id}")
    public ResponseEntity<List<FacultyAttendance>> getFacultyAttendance(@PathVariable String id){
        
        List<FacultyAttendance> dn = service.getFacultyAttendanceById(id);
        
        if(dn != null)
            return new ResponseEntity<>(dn, HttpStatus.OK); 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //    http://localhost:8080/api/FacultyAttendance
    @PostMapping("/FacultyAttendance")
    public ResponseEntity<?> addFacultyAttendance(@RequestBody FacultyAttendance facultyAttendance){
            service.addFacultyAttendance(facultyAttendance);
            return null;
    }
    
    //    http://localhost:8080/api/FacultyAttendance/pavan
    @PutMapping("/FacultyAttendance/{id}")
    public ResponseEntity<FacultyAttendance> updateFacultyAttendance(@PathVariable String id, @RequestBody FacultyAttendance facultyAttendance){
        
        FacultyAttendanceComposite facultyAttendanceComposite = facultyAttendance.getCompositeKey();
        if(!facultyAttendanceComposite.getId().equals(id))
            return new ResponseEntity<>(new FacultyAttendance("Something went wrong"), HttpStatus.BAD_REQUEST);
        
        FacultyAttendance fa = null;
        fa = service.updateFacultyAttendance(facultyAttendance);
//        System.out.println(dn.toString());
        if(fa != null)
            return new ResponseEntity<>(new FacultyAttendance("Data has been Updated"), HttpStatus.OK);
        else
            return new ResponseEntity<>(new FacultyAttendance("No data found with "+id), HttpStatus.BAD_REQUEST);
    }
    
    //    http://localhost:8080/api/FacultyAttendance/Parvathi
    @DeleteMapping("/FacultyAttendance/{id}")
    public ResponseEntity<FacultyAttendance> deleteFacultyAttendance(@PathVariable String id, @RequestBody FacultyAttendance facultyAttendance){
        
        FacultyAttendanceComposite facultyAttendanceComposite = facultyAttendance.getCompositeKey();
        if(!facultyAttendanceComposite.getId().equals(id))
            return new ResponseEntity<>(new FacultyAttendance("Something went wrong"), HttpStatus.BAD_REQUEST);
        
        FacultyAttendance fa = null;
        fa = service.deleteFacultyAttendance(facultyAttendance);
        if(fa != null){
//            service.deleteDepartmentNews(id);
            return new ResponseEntity<>(new FacultyAttendance("Data has been deleted"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new FacultyAttendance("No data found with "+id), HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/FacultyAttendance/search")
    public ResponseEntity<List<FacultyAttendance>> searchFacultyAttendance(@RequestParam String keyword){
        List<FacultyAttendance> facultyattendance = service.searchFacultyAttendance(keyword);
        return new ResponseEntity<>(facultyattendance, HttpStatus.OK);
    }
}
