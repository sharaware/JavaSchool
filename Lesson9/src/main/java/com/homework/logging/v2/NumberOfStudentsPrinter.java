package com.homework.logging.v2;

import com.homework.logging.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NumberOfStudentsPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfStudentsPrinter.class);
    public void printNumberOfAllStudentsPresent(List<Student> students) {
        //Напечатать количество студентов, которые присутствовали на тесте (имеют оценку) с уровнем info
        int count = 0;
        for(Student student : students) {
            if(student.getResult() != null)
                count++;
        }
        LOGGER.info("На тесте присутствовало {} студентов", count);
    }

    public void printNumberOfStudentsWith5And4(List<Student> students) {
        //Напечатать количество студентов, имеющих оценку 5, и имеющих оценку 4 (значения суммировать не надо). Записать необходимо в одну строку.
        //Лог должен выводиться с уровнем debug
        int cnt5 = 0, cnt4 = 0;
        for(Student student : students) {
            Integer result = student.getResult();
            if (result != null) {
                switch (result) {
                    case 4:
                        cnt4++;
                        break;
                    case 5:
                        cnt5++;
                        break;
                }
            }
        }
        LOGGER.debug("{} студентов получили оценку 5 и {} получили оценку 4", cnt5, cnt4);
    }
}