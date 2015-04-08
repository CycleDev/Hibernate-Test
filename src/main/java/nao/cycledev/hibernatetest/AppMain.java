package nao.cycledev.hibernatetest;

import nao.cycledev.hibernatetest.domain.Student;
import nao.cycledev.hibernatetest.repository.DBStudentRepository;

import java.util.List;

public class AppMain {

    public static void main(String[] args){
        DBStudentRepository db = new DBStudentRepository();

        //System.out.println("Criating students ....");
        //db.create(null);

        System.out.println("Next student where created");
        List students = db.getAll();

        for(Student student : (List<Student>)students){
            System.out.println("First Name: " + student.getFirstName() + "; Last Name: " + student.getLastName());
        }
    }
}
