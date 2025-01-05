/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workgroup.ppk.cse.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workgroup.ppk.cse.model.FacultyAttendance;
import workgroup.ppk.cse.model.FacultyAttendanceComposite;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Repository
// Type of class or Type of entity and Primary key Type  JpaRepository<Product, Integer>
public interface FacultyAttendanceRepo extends JpaRepository<FacultyAttendance, FacultyAttendanceComposite> {
    
    @Query("SELECT f from FacultyAttendance f WHERE "+
            "LOWER(f.compositeKey.id) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<FacultyAttendance> searchFacultyAttendance(String keyword);
    
    @Query("SELECT f from FacultyAttendance f WHERE "+
            "LOWER(f.compositeKey.id) = :keyword")
    List<FacultyAttendance> findByID(String keyword);
    
    @Query("SELECT f from FacultyAttendance f WHERE "+
            "LOWER(f.compositeKey.id) = :id "+
            "f.compositeKey.year = :year "+
            "LOWER(f.compositeKey.month) = :month")
    FacultyAttendance findByIdYearMonth(String id, int year, String month);
    
    @Query("DELETE from FacultyAttendance f WHERE "+
            "LOWER(f.compositeKey.id) = :id "+
            "f.compositeKey.year = :year "+
            "LOWER(f.compositeKey.month) = :month")
    FacultyAttendance deleteByIdYearMonth(String id, int year, String month);
}
