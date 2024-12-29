/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.StudentMarksheet;
import workgroup.ppk.cse.repo.StudentMarksheetRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class StudentMarksheetService {
    
    @Autowired
    private StudentMarksheetRepo repo;

    public List<StudentMarksheet> getAllStudentMarksheet() {
        return repo.findAll();
    }

    public List<StudentMarksheet> searchStudentMarksheet(String keyword) {
        return repo.searchStudentMarksheet(keyword);
    }
}
