/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.FacultyAttendance;
import workgroup.ppk.cse.repo.FacultyAttendanceRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class FacultyAttendanceService {
    
    @Autowired
    private FacultyAttendanceRepo repo;

    public List<FacultyAttendance> getAllFacultyAttendance() {
        return repo.findAll();
    }

    public List<FacultyAttendance> searchFacultyAttendance(String keyword) {
//        return repo.searchFacultyAttendance(keyword);
        return repo.searchFacultyAttendance(keyword);
    }
}
