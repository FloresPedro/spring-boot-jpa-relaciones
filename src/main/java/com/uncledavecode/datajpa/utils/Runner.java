package com.uncledavecode.datajpa.utils;

import com.uncledavecode.datajpa.model.Student;
import com.uncledavecode.datajpa.repository.CourseRepository;
import com.uncledavecode.datajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;
@Transactional
@Component
public class Runner implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Runner(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        //Save and SaveALL
        //Student student1 = new Student("John", "Doe", LocalDate.of(1980, 1, 1));
        //Student student2 = new Student("Jane", "Doe", LocalDate.of(1990, 1, 1));

        //studentRepository.saveAll(Set.of(student1, student2));

        // FindAll Usando @Query
        //studentRepository.findByFirstName("Leora").forEach(System.out::println);
        //studentRepository.findByFirstNameLike("ri").forEach(System.out::println);
        //studentRepository.findByFirstNameNative("Dari").forEach(System.out::println);
        //studentRepository.findByFirstNameLastNameNamed("Leora","Tutill").forEach(System.out::println);
        //El componente debe de ser marcado como transaccional
        //studentRepository.updateFirstNameById(5L,"Pedrito");
        //studentRepository.findByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        //studentRepository.readByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        //studentRepository.getByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        //studentRepository.queryByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        //studentRepository.searchByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        //studentRepository.streamByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);

//        if(studentRepository.existsByFirstname("Pedrito")){
//            System.out.println("Pedrin existe");
//        }
//
//        System.out.println(studentRepository.count());
//        System.out.println(studentRepository.countByFirstname("Pedrito"));
//        studentRepository.deleteByFirstname("Misti");
        //IgnoreCase para buscar entre mayusculas y minusculas
//        studentRepository.findByContactInfo_StateIgnoreCase("michigan").forEach(System.out::println);
        //studentRepository.findByContactInfo_StateIgnoreCaseOrderByFirstnameAscLastnameDesc("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderById("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderByIdDesc("michigan").forEach(System.out::println);
        //usando un operador logico en la descripcion del metodo
        //studentRepository.findByContactInfo_StateOrContactInfo_State("Michigan", "Ohio").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoreCase("michigan","ohio").forEach(System.out::println);
//        //Ordenamiento
//        studentRepository.findAll(Sort.by(Sort.Direction.ASC,"firstname")).forEach(System.out::println);
//        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"birthDate"), new Sort.Order(Sort.Direction.ASC,"firstname"));
//        studentRepository.findAll(sort).forEach(System.out::println);
//        System.out.println("Page 1");
//        Pageable pageable = PageRequest.of(0,6,Sort.Direction.DESC,"birthDate");
//        studentRepository.findAll(pageable).forEach(System.out::println);
//        pageable = PageRequest.of(1,6,Sort.Direction.DESC,"birthDate");
//        System.out.println("Page 2");
//        studentRepository.findAll(pageable).forEach(System.out::println);


        var result = courseRepository.findByInstructor_Id(1L);
        for (var course: result){
            System.out.println(course.getName() + " -> Intructor: " + course.getInstructorName() +" -> Student: "+ course.getStudentCount());
        }

    }
}
