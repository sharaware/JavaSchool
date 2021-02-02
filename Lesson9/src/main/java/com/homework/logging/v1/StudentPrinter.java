package com.homework.logging.v1;

import com.homework.logging.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentPrinter.class);

    public void printAllNotPresentStudents(List<Student> students) {
        //Напечатать список всех студентов, которые отсутствовали на тесте (нет оценки) с уровнем warn
        for(Student student : students) {
            if (student.getResult() == null) {
                LOGGER.warn("Студент {} {} гуляет", student.getFirstName(), student.getLastName());
            }
        }
    }

    public void printAllStudents(List<Student> students) {
        //Напечатать список всех студентов с уровнем info
        for(Student student : students) {
            LOGGER.info(student.toString());
        }
    }

    public void printAllStudentsWith2(List<Student> students) {
        //Напечатать список всех студентов, которые имеют оценку 2 c уровнем error
        for(Student student : students) {
            if (student.getResult() != null && student.getResult() == 2) {
                LOGGER.error("Студент {} {} получил двойку! На пересдачу!", student.getFirstName(), student.getLastName());
            }
        }
    }
}