/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.StudentAttendance;
import workgroup.ppk.cse.repo.StudentAttendanceRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class StudentAttendanceService {
    
    @Autowired
    private StudentAttendanceRepo repo;

    public List<StudentAttendance> getAllStudentAttendance() {
        return repo.findAll();
    }

    public List<StudentAttendance> searchStudentAttendance(String keyword) {
        return repo.searchStudentAttendance(keyword);
    }
}
