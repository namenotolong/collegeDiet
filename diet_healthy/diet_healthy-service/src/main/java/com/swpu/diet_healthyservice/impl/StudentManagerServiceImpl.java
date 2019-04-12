package com.swpu.diet_healthyservice.impl;

import com.swpu.diet_healthydao.StudentManagerDao;
import com.swpu.diet_healthydomain.Student;
import com.swpu.diet_healthyservice.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentManagerServiceImpl implements StudentManagerService {
    @Autowired
    private StudentManagerDao studentManagerDao;
    @Override
    public List<Student> checkAllStudent(int startIndex, int perList) {
        return studentManagerDao.checkAllStudent(startIndex, perList);
    }

    @Override
    public int getAllStudentCount() {
        return studentManagerDao.getAllStudentCount();
    }

    @Override
    public boolean addStudent(Student student) {
        return studentManagerDao.addStudent(student) > 0;
    }

    @Override
    public boolean checkStudentPhone(Student student) {
        return studentManagerDao.checkStudentPhone(student) == null;
    }

    @Override
    public boolean delStudent(Integer id) {
        return studentManagerDao.delStudent(id) > 0;
    }

    @Override
    public boolean modifyStudent(Student student) {
        return studentManagerDao.modifyStudent(student) > 0;
    }

    @Override
    public boolean checkStudentNickName(Student student) {
        return studentManagerDao.checkStudentNickName(student) == null;
    }

    @Override
    public List<Student> searchStudent(Student student) {
        return studentManagerDao.searchStudent(student);
    }

    @Override
    public int searchStudentCount(Student student) {
        return studentManagerDao.searchStudentCount(student);
    }
}
