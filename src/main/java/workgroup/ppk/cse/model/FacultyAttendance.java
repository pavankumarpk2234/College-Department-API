/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  
/**
 *
 * @author WE ARE ANONYMOUS
 */

@Entity // To create a table in database because JPA needs entity.
@Data // Invoking Lombok
@AllArgsConstructor // Creates constructors for all arguments
@NoArgsConstructor // Create constructor with no arguments
public class FacultyAttendance {
    
    @EmbeddedId
    private FacultyAttendanceComposite compositeKey;
    private String name;
    private int attendance;

//    public FacultyAttendance(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public FacultyAttendance(String name) {
        this.name = name;
    }
    
    
}
