/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workgroup.ppk.cse.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workgroup.ppk.cse.model.FacultyDetails;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Repository
// Type of class or Type of entity and Primary key Type  JpaRepository<Product, Integer>
public interface FacultyDetailsRepo extends JpaRepository<FacultyDetails, String> {
    
    @Query("SELECT f from FacultyDetails f WHERE "+
            "LOWER(f.id) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.subject) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.qualification) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<FacultyDetails> searchFacultyDetails(String keyword);
}
