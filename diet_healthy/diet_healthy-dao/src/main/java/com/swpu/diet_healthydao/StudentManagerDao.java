package com.swpu.diet_healthydao;

import com.swpu.diet_healthydomain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentManagerDao {
    List<Student> checkAllStudent(@Param("startIndex") int startIndex, @Param("perList") int perList);
    int getAllStudentCount();
    int addStudent(Student student);
    Student checkStudentPhone(Student student);
    int delStudent(Integer id);
    int  modifyStudent(Student student);
    Student checkStudentNickName(Student student);
    List<Student> searchStudent(Student student);
    int searchStudentCount(Student student);
}
