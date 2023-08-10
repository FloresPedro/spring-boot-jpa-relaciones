package com.uncledavecode.datajpa.model;

import com.uncledavecode.datajpa.model.embedded_id.StudentCourse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //Relacion uno a muchos bidireccional: le decimos a hibernate que todos los datos deben de ser obtenidos inmediatamente
    //es decir optener todos los cursos del instructor en la primera llamada
    //LAZZY: que no se traiga todos los cursos relacionados con el instructor solo si se solicita(instructor.getCourses())
    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;

    //Relacion muchos a mucho
    //idClass
//    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
//    private Set<StudentCourse> studentCourses = new HashSet<>();

    //EmbeddedId
    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses = new HashSet<>();
}
