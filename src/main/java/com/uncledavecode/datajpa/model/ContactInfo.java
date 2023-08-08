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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_info_generator")
    @SequenceGenerator(name = "contact_info_generator", allocationSize = 1)
    private Long id;
    private String email;
    private String phone, address,city,state,zip;
}
