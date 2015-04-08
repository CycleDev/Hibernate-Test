package nao.cycledev.hibernatetest.repository;

import nao.cycledev.hibernatetest.domain.Student;

import java.util.List;

interface BaseStudentRepository {

    List<Student> getAll();

    void create(Student student);

}
