/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workgroup.ppk.cse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
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
public class EventsAndDetails {
    
    @Id // id is primary key in table.
    private String name;
    private String description;
    private int firstYear;
    private int secondYear;
    private int thirdYear;
    private int fourthYear;
    private int totalParticipation;
    private int winners;
    private Date date;

    public EventsAndDetails(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
}
