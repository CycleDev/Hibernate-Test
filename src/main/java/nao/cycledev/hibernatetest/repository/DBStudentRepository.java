package nao.cycledev.hibernatetest.repository;

import nao.cycledev.hibernatetest.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBStudentRepository implements BaseStudentRepository {

    private SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public List<Student> getAll() {

        List<Student> students = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            students = (List<Student>)session.createQuery(" From Student ").list();
        }
        finally{
            session.getTransaction().commit();
            session.close();
        }

        return students;

    }

    public void create(Student student) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(new Student(1, "Nazar", "Oprysk", "0978119863", "oprysk.nazar@gmail.com"));
            session.save(new Student(2, "Luda", "Oprysk", "911", "luda.oprysk@gmail.com"));
        }
        finally{
            session.getTransaction().commit();
            session.close();
        }

    }
}
