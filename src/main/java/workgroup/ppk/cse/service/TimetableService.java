/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.Timetable;
import workgroup.ppk.cse.repo.TimetableRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class TimetableService {
    
    @Autowired
    private TimetableRepo repo;

    public List<Timetable> getAllTimetable() {
        return repo.findAll();
    }

    public Timetable getTimetableById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Timetable> searchTimetable(String keyword) {
        return repo.searchTimetable(keyword);
    }
}
