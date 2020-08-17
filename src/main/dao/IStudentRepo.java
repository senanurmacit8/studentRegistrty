package src.main.dao;

import src.main.model.Student;

import java.util.List;

public interface IStudentRepo {

    List<Student> findAll();

    Student findById(Long id);

    void studentCreate(Student student);

    Student studentUpdate(Student student);
}
