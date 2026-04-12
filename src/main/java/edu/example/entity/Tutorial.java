package edu.example.entity;

import jakarta.persistence.*;
import lombok.*;

/*
This is an entity class targeted by JPA using hibernate to persist the state of the Tutorial object
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="tuto")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tname",unique = true, length= 200,nullable = false)
    private String title;

    @Column(name="tdetails",length= 200)
    private String description;

    @Column(name="tpub")
    private Boolean published;

    public Tutorial(String title, String description, Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
