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
import workgroup.ppk.cse.model.StudentAttendance;
import workgroup.ppk.cse.service.StudentAttendanceService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class StudentAttendanceController {
    
    @Autowired
    private StudentAttendanceService service;
    
//    http://localhost:8080/api/StudentAttendance
    @GetMapping("/StudentAttendance")
    public List<StudentAttendance> getAllStudentAttendance(){
        return service.getAllStudentAttendance();
    }
    
    @GetMapping("/StudentAttendance/search")
    public ResponseEntity<List<StudentAttendance>> searchStudentAttendance(@RequestParam String keyword){
        List<StudentAttendance> studentattendance = service.searchStudentAttendance(keyword);
        return new ResponseEntity<>(studentattendance, HttpStatus.OK);
    }
}
