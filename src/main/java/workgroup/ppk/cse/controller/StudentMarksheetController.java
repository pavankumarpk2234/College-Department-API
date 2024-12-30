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
import workgroup.ppk.cse.model.StudentMarksheet;
import workgroup.ppk.cse.service.StudentMarksheetService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
@CrossOrigin
@RequestMapping("/api")
public class StudentMarksheetController {
    
    @Autowired
    private StudentMarksheetService service;
    
//    http://localhost:8080/api/StudentMarksheet
    @GetMapping("/StudentMarksheet")
    public List<StudentMarksheet> getAllStudentMarksheet(){
        return service.getAllStudentMarksheet();
    }
    
    @GetMapping("/StudentMarksheet/search")
    public ResponseEntity<List<StudentMarksheet>> searchStudentMarksheet(@RequestParam String keyword){
        List<StudentMarksheet> studentmarksheet = service.searchStudentMarksheet(keyword);
        return new ResponseEntity<>(studentmarksheet, HttpStatus.OK);
    }
}
