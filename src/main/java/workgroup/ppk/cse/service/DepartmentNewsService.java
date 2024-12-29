/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workgroup.ppk.cse.model.DepartmentNews;
import workgroup.ppk.cse.repo.DepartmentNewsRepo;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Service
public class DepartmentNewsService {
    
    @Autowired
    private DepartmentNewsRepo repo;

    public List<DepartmentNews> getAllDepartmentNews() {
        return repo.findAll();
    }

    public DepartmentNews getDepartmentNewsById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<DepartmentNews> searchDepartmentNews(String keyword) {
        return repo.searchDepartmentNews(keyword);
    }
    
}
