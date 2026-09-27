package com.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userProfile")
@ToString(exclude = "user")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String profileDescription;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;
}
