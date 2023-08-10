package com.uncledavecode.datajpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ContactInfo {

    //Relacion 1 a 1 compartiendo la misma llave primaria (Se modifica el codigo)
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_info_generator")
    //@SequenceGenerator(name = "contact_info_generator", allocationSize = 1)
    @Column(name = "student_id")
    private Long id;
    private String email;
    private String phone, address,city,state,zip;

    //relacion utilizando llave foranea
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_id")
    //para indicar que los valores seran copiados desde la tabla student y compartiran el mismo id
    @MapsId
    private Student student;
}
