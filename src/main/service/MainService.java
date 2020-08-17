package src.main.service;

import com.sun.nio.sctp.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import src.main.dao.ILessonRepo;
import src.main.dao.IStudentRepo;
import src.main.exceptionHandler.MaxStudentQuataFailed;
import src.main.exceptionHandler.StudentNotFoundException;
import src.main.model.Lesson;
import src.main.model.Student;

import java.util.List;

@Service
public class MainService implements IMainService {

    private IStudentRepo studentRepo;
    private ILessonRepo lessonRepo;

    @Autowired
    public void setStudentRepo(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> findStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findStudent(Long id) throws StudentNotFoundException {
        Student student = studentRepo.findById(id);
        if (student == null) throw new StudentNotFoundException("Student not found: " + id);
        return student;
    }

    @Override
    public void createStudent(Student student) {
        studentRepo.studentCreate(student);
    }

    @Override
    public void studentUpdate(Student student) {
        studentRepo.studentUpdate(student);
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public List<Lesson> findLessons() {
        return lessonRepo.findAll();
    }

    @Override
    public void addLesson(Lesson lesson) {
        lessonRepo.lessonCreate(lesson);

    }

}
