/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workgroup.ppk.cse.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workgroup.ppk.cse.model.Timetable;

/**
 *
 * @author WE ARE ANONYMOUS
 */

@Repository
// Type of class or Type of entity and Primary key Type  JpaRepository<Product, Integer>
public interface TimetableRepo extends JpaRepository<Timetable, String> {
    
    @Query("SELECT t from Timetable t WHERE "+
            "LOWER(t.academicYear) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.classTeacher) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Timetable> searchTimetable(String keyword);
}
