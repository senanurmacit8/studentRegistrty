package src.main.dao.inmemory;

import org.springframework.stereotype.Repository;
import src.main.dao.IStudentRepo;
import src.main.model.Student;

import java.util.*;

@Repository
public class StudentInMemory implements IStudentRepo {

    private Map<Long , Student> studentMap = new HashMap<>();

    public StudentInMemory(){

        Student student1 = new Student();
        student1.setStudentId(1L);
        student1.setStudentName("Sena");
        student1.setStudentLastname("macit");

        Student student2 = new Student();
        student2.setStudentId(2L);
        student2.setStudentName("denemeAd");
        student2.setStudentLastname("denemeSoyad");

        studentMap.put(student1.getStudentId(), student1);
        studentMap.put(student2.getStudentId(),student2);

    }

    public List<Student> findAll(){
     return new ArrayList<>(studentMap.values());
    }

    public Student findById(Long id ){
        return studentMap.get(id);
    }

    @Override
    public void studentCreate(Student student) {
        student.setStudentId(new Date().getTime());
        studentMap.put(student.getStudentId(), student);
    }

    @Override
    public Student studentUpdate(Student student) {
        studentMap.replace(student.getStudentId(),student);
        return student;
    }

}
