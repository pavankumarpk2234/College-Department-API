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
import workgroup.ppk.cse.model.DepartmentNews;
import workgroup.ppk.cse.service.DepartmentNewsService;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@RestController // @RestController will return the data and @Contoller will return file name.
//@Controller
@CrossOrigin
@RequestMapping("/api")
public class DepartmentNewsController {
    
    @Autowired
    private DepartmentNewsService service;
    
//        @RequestMapping("/")
//        public String greet(){
//            return "Hello World";
//        }
    
//    http://localhost:8080/api/DepartmentNews
    @GetMapping("/DepartmentNews")
    public List<DepartmentNews> getAllDepartmentNews(){
        return service.getAllDepartmentNews();
    }
    
//    http://localhost:8080/api/DepartmentNews
//    @GetMapping("/DepartmentNews")
//    public String getAllDepartmentNews(Model model){
//        model.addAttribute("DepartmentNews", service.getAllDepartmentNews());
//        return "DepartmentNews";
//    }
    
    
//    http://localhost:8080/api/DepartmentNews/Parvathi
    @GetMapping("/DepartmentNews/{id}")
    public ResponseEntity<DepartmentNews> getDepartmentNews(@PathVariable String id){
        
        DepartmentNews dn = service.getDepartmentNewsById(id);
        
        if(dn != null)
            return new ResponseEntity<>(dn, HttpStatus.OK); 
        else
            return new ResponseEntity<>(new DepartmentNews("Error", "No data found with "+id),HttpStatus.NOT_FOUND);
    }
    
//    http://localhost:8080/api/DepartmentNews
    @PostMapping("/DepartmentNews")
    public ResponseEntity<?> addDepartmentNews(@RequestBody DepartmentNews departmentNews){
            service.addDepartmentNews(departmentNews);
            return null;
    }
    
//    http://localhost:8080/api/DepartmentNews/Parvathi
    @PutMapping("/DepartmentNews/{id}")
    public ResponseEntity<DepartmentNews> updateDepartmentNews(@PathVariable String id, @RequestBody DepartmentNews departmentNews){
        DepartmentNews dn = null;
        dn = service.updateDepartmentNews(id, departmentNews);
//        System.out.println(dn.toString());
        if(dn != null)
            return new ResponseEntity<>(new DepartmentNews("Success", "Data has been Updated"), HttpStatus.OK);
        else
            return new ResponseEntity<>(new DepartmentNews("Error", "No data found with "+id), HttpStatus.BAD_REQUEST);
    }
    
//    http://localhost:8080/api/DepartmentNews/Parvathi
    @DeleteMapping("/DepartmentNews/{id}")
    public ResponseEntity<DepartmentNews> deleteDepartmentNews(@PathVariable String id){
        DepartmentNews dn = service.deleteDepartmentNews(id);
        if(dn != null){
//            service.deleteDepartmentNews(id);
            return new ResponseEntity<>(new DepartmentNews("Success", "Data has been deleted"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new DepartmentNews("Error", "No data found with "+id), HttpStatus.NOT_FOUND);
    }
    
    // insert into department_news values("Pavan Kumar", "I am a Java Developer");
    // http://localhost:8080/api/DepartmentNews/search?keyword=pavan
    @GetMapping("/DepartmentNews/search")
    public ResponseEntity<List<DepartmentNews>> searchDepartmentNews(@RequestParam String keyword){
        List<DepartmentNews> ldn = service.searchDepartmentNews(keyword);
//        System.out.println("Searching with " + keyword);
        return new ResponseEntity<>(ldn, HttpStatus.OK);
    }
}