/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.StudentDetails;
import workgroup.ppk.cse.repo.StudentDetailsRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class StudentDetailsService {
    
    @Autowired
    private StudentDetailsRepo repo;

    public List<StudentDetails> getAllStudentDetails() {
        return repo.findAll();
    }

    public StudentDetails getStudentDetailsById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<StudentDetails> searchStudentDetails(String keyword) {
        return repo.searchStudentDetails(keyword);
    }
}
