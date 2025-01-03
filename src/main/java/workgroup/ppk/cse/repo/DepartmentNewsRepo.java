/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workgroup.ppk.cse.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workgroup.ppk.cse.model.DepartmentNews;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Repository
// Type of class or Type of entity and Primary key Type  JpaRepository<Product, Integer>
public interface DepartmentNewsRepo extends JpaRepository<DepartmentNews, String> {
    
    @Query("SELECT d from DepartmentNews d WHERE "+
            "LOWER(d.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(d.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<DepartmentNews> searchDepartmentNews(String keyword);
    
    @Query("SELECT d from DepartmentNews d WHERE "+
            "LOWER(d.title) = :keyword")
    DepartmentNews findByID(String keyword);
}
