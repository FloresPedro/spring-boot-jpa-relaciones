package com.uncledavecode.datajpa.model;

import com.uncledavecode.datajpa.model.embedded_id.StudentCourse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", allocationSize = 1)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstname;
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    //con esto indicamos que los valores de la llave primaria student van a ser compartidos como la llave primaria de contact_info
    @PrimaryKeyJoinColumn
    private ContactInfo contactInfo;

    //Relacion muchos a muchos
   /* @ManyToMany
    @JoinTable(name = "stundet_course",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();*/

    //IdClass
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<StudentCourse> studentCourses = new HashSet<>();

    //EmbeddedId
    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourses = new HashSet<>();
}
