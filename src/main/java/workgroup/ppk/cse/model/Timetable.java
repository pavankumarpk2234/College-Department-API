/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Timetable {
    // @EmbeddedId
    private String academicYear;
    private char section;
    @Id // id is primary key in table.
    private String classTeacher;
    private String r1c1;
    private String r1c2;
    private String r1c3;
    private String r1c4;
    private String r1c5;
    private String r1c6;
    private String r1c7;
    private String r1c8;
    private String r2c1;
    private String r2c2;
    private String r2c3;
    private String r2c4;
    private String r2c5;
    private String r2c6;
    private String r2c7;
    private String r2c8;
    private String r3c1;
    private String r3c2;
    private String r3c3;
    private String r3c4;
    private String r3c5;
    private String r3c6;
    private String r3c7;
    private String r3c8;
    private String r4c1;
    private String r4c2;
    private String r4c3;
    private String r4c4;
    private String r4c5;
    private String r4c6;
    private String r4c7;
    private String r4c8;
    private String r5c1;
    private String r5c2;
    private String r5c3;
    private String r5c4;
    private String r5c5;
    private String r5c6;
    private String r5c7;
    private String r5c8;
    private String r6c1;
    private String r6c2;
    private String r6c3;
    private String r6c4;
    private String r6c5;
    private String r6c6;
    private String r6c7;
    private String r6c8;
    private String r7c1;
    private String r7c2;
    private String r7c3;
    private String r7c4;
    private String r7c5;
    private String r7c6;
    private String r7c7;
    private String r7c8;

    public Timetable(String academicYear, String classTeacher) {
        this.academicYear = academicYear;
        this.classTeacher = classTeacher;
    }
    
    
}

// 7*8 = 56