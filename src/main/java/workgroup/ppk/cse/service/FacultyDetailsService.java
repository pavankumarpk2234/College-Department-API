/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.FacultyDetails;
import workgroup.ppk.cse.repo.FacultyDetailsRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class FacultyDetailsService {
    
    @Autowired
    private FacultyDetailsRepo repo;

    public List<FacultyDetails> getAllFacultyDetails() {
        return repo.findAll();
    }

    public FacultyDetails getFacultyDetailsById(String id) {
        return repo.findById(id).orElse(new FacultyDetails("Error", "No data found with "+id));
    }

    public List<FacultyDetails> searchFacultyDetails(String keyword) {
        return repo.searchFacultyDetails(keyword);
    }
}
