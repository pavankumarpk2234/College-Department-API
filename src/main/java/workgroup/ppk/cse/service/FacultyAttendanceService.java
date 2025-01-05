/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.FacultyAttendance;
import workgroup.ppk.cse.model.FacultyAttendanceComposite;
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
    
    public List<FacultyAttendance> getFacultyAttendanceById(String id) {
        return repo.findByID(id);
    }
    
    public FacultyAttendance addFacultyAttendance(FacultyAttendance facultyAttendance) {
        return repo.save(facultyAttendance);
    }
    
    public FacultyAttendance updateFacultyAttendance(FacultyAttendance facultyAttendance) {
        
        FacultyAttendanceComposite facultyAttendanceComposite = facultyAttendance.getCompositeKey();
        
        String id = facultyAttendanceComposite.getId().toLowerCase();
        int year = facultyAttendanceComposite.getYear();
        String month = facultyAttendanceComposite.getMonth().toLowerCase();
        FacultyAttendance fa = (FacultyAttendance) repo.findByIdYearMonth(id, year, month);
        
        if(fa == null)
            return null;
        
//        FacultyAttendanceComposite facultyAttendanceComposite = facultyAttendance.getCompositeKey();
        FacultyAttendanceComposite fac = fa.getCompositeKey();
        
        fac.setId(facultyAttendanceComposite.getId());
        fac.setYear(facultyAttendanceComposite.getYear());
        fac.setMonth(facultyAttendanceComposite.getMonth());
        fa.setName(facultyAttendance.getName());
        fa.setAttendance(facultyAttendance.getAttendance());
        return repo.save(facultyAttendance);
    }
    
    public FacultyAttendance deleteFacultyAttendance(FacultyAttendance facultyAttendance) {
        
        FacultyAttendanceComposite facultyAttendanceComposite = facultyAttendance.getCompositeKey();
        
        String id = facultyAttendanceComposite.getId().toLowerCase();
        int year = facultyAttendanceComposite.getYear();
        String month = facultyAttendanceComposite.getMonth().toLowerCase();
        FacultyAttendance fa = (FacultyAttendance) repo.findByIdYearMonth(id, year, month);
        
        if(fa == null)
            return null;
        repo.deleteByIdYearMonth(id, year, month);
        return new FacultyAttendance("");
    }

    public List<FacultyAttendance> searchFacultyAttendance(String keyword) {
//        return repo.searchFacultyAttendance(keyword);
        return repo.searchFacultyAttendance(keyword);
    }
}
