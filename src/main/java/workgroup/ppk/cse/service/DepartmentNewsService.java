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

    public DepartmentNews getDepartmentNewsById(String id) {
        return repo.findById(id).orElse(new DepartmentNews("Error", "No data found with "+id));
    }
    
    public DepartmentNews addDepartmentNews(DepartmentNews departmentNews) {
        return repo.save(departmentNews);
    }
    
    public DepartmentNews deleteDepartmentNews(String id1) {
        String id = id1.toLowerCase();
        DepartmentNews dn = (DepartmentNews) repo.findByID(id);
        
        if(dn == null)
            return null;
        repo.deleteById(id);
        return new DepartmentNews("Success", "Data has been deleted");
    }

    public List<DepartmentNews> searchDepartmentNews(String keyword) {
        return repo.searchDepartmentNews(keyword);
    }

    public DepartmentNews updateDepartmentNews(String id1, DepartmentNews departmentNews) {
        String id = id1.toLowerCase();
        DepartmentNews dn = (DepartmentNews) repo.findByID(id);
        
        if(dn == null)
            return null;
        dn.setTitle(departmentNews.getTitle());
        dn.setDescription(departmentNews.getDescription());
        return repo.save(departmentNews);
    }
}
