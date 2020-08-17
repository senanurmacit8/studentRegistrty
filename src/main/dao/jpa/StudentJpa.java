package src.main.dao.jpa;

import org.springframework.stereotype.Repository;
import src.main.dao.IStudentRepo;
import src.main.model.Student;

import java.util.List;


@Repository("studentRepo")
public class StudentJpa implements IStudentRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();

    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void studentCreate(Student student) {
        entityManager.persist(student);
    }
}
