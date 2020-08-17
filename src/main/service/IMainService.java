package src.main.service;

import src.main.exceptionHandler.StudentNotFoundException;
import src.main.model.Lesson;
import src.main.model.Student;

import java.util.List;

public interface IMainService {

    List<Student> findStudents();

    Student findStudent(Long id) throws StudentNotFoundException;

    void createStudent(Student student);

    void studentUpdate(Student student);

    void deleteStudent(Long id);

    List<Lesson> findLessons();

    void addLesson(Lesson lesson);
}
