package com.uncledavecode.datajpa.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

//Interfaz para solo regresar ciertos elentos de una entidad
public interface CourseDTO {
    Long getId();
    String getName();
    @Value("#{target.instructor.getFirstName}")
    String getInstructorName();
    @Value("#{target.studentCourses.size()}")
    int getStudentCount();
}
