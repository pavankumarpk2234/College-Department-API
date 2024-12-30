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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workgroup.ppk.cse.model.FacultyAttendance;
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
    
    @GetMapping("/FacultyAttendance/search")
    public ResponseEntity<List<FacultyAttendance>> searchFacultyAttendance(@RequestParam String keyword){
        List<FacultyAttendance> facultyattendance = service.searchFacultyAttendance(keyword);
        return new ResponseEntity<>(facultyattendance, HttpStatus.OK);
    }
}
