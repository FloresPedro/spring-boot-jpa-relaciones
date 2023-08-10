package com.uncledavecode.datajpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructor")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_generator")
    @SequenceGenerator(name = "instructor_generator", allocationSize = 1)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //Relacion uno a muchos se utiliza un Set para guardar todos los cursos que puede tener un instructor
    //Unidireccional, solo se agrea en la entidad instructor en la entidad curso no se realiza nada
    //para la relacion bidireccional se agrega el mappedBy y cascade de tipo ALL(propagar los cambios a todos los cursos relacionados al instructor) al igual que en la propiedad course
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();


}
