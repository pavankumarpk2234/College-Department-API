/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workgroup.ppk.cse.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workgroup.ppk.cse.model.StudentMarksheet;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Repository
// Type of class or Type of entity and Primary key Type  JpaRepository<Product, Integer>
public interface StudentMarksheetRepo extends JpaRepository<StudentMarksheet, Integer> {
    
    @Query("SELECT s from StudentMarksheet s WHERE "+
            "LOWER(s.id) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.academicYear) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.semister) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.subjectName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<StudentMarksheet> searchStudentMarksheet(String keyword);
}
