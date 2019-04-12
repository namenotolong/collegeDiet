package com.swpu.diet_healthyservice;

import com.swpu.diet_healthydomain.Student;

import java.util.List;

public interface StudentManagerService {
    List<Student> checkAllStudent(int startIndex, int perList);
    int getAllStudentCount();
    boolean addStudent(Student student);
    boolean checkStudentPhone(Student student);
    boolean delStudent(Integer id);
    boolean modifyStudent(Student student);
    boolean checkStudentNickName(Student student);
    List<Student> searchStudent(Student student);
    int searchStudentCount(Student student);
}
