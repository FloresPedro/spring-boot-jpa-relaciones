package com.uncledavecode.datajpa.repository;

import com.uncledavecode.datajpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPQL Query

    //Usando la notacion @Query
    @Query("select s from Student s where s.firstname = ?1")
    List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.firstname like %?1%")
    List<Student> findByFirstNameLike(String firstName);

    //Native SQL Query
    @Query(value = "select * from student where first_name = ?1", nativeQuery = true)
    List<Student> findByFirstNameNative(String firstName);

    //Tomando los nombres de los parametros
    @Query("select s from Student s where s.firstname = :firstName and s.lastname = :lastName")
    List<Student> findByFirstNameLastNameNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //Actualizacion de entidades
    @Modifying
    @Query("update Student s set s.firstname = :firstName where s.id = :id")
    void updateFirstNameById(@Param("id") Long id, @Param("firstName") String firstName);

    //que el framework ejecute la consulta
    //El secreto esta en la entidad, las palabras que se usan para nombrar el metodo "findBy-campo-GreaterThan-"
    List<Student> findByBirthDateGreaterThan(LocalDate b);
    List<Student> readByBirthDateGreaterThan(LocalDate b);
    List<Student> getByBirthDateGreaterThan(LocalDate b);
    List<Student> queryByBirthDateGreaterThan(LocalDate b);
    List<Student> searchByBirthDateGreaterThan(LocalDate b);
    List<Student> streamByBirthDateGreaterThan(LocalDate b);

    boolean existsByFirstname(String firstName);
    int countByFirstname(String firstName);

    void deleteByFirstname(String firstName);
    void removeByFirstname(String firstName);

    //multiples tablas
    //
    List<Student> findByContactInfo_StateIgnoreCase(String state);
    List<Student> findByContactInfo_StateIgnoreCaseOrderByFirstnameAscLastnameDesc(String state);
    List<Student> findByContactInfo_StateIgnoreCaseOrderById(String state);
    List<Student> findByContactInfo_StateIgnoreCaseOrderByIdDesc(String state);
    //Listar con operadores logicos (AllIgnoreCase) para ignorar todos los parametros
    List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoreCase(String state1, String state2);

    //Native query paging
    @Query(value = "select * from student where first_name = ?1",
            countQuery = "select count(*) from student where first_name = ?1",nativeQuery = true)
    Page<Student> findByFirstnameNativePaging(String firstName, Pageable pageable);
}
