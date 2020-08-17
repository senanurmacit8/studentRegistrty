package src.main.dao.inmemory;

import org.springframework.stereotype.Repository;
import src.main.dao.ILessonRepo;
import src.main.dao.IStudentRepo;
import src.main.model.Lesson;
import src.main.model.Student;

import java.util.*;

@Repository
public class LesssonInMemory implements ILessonRepo {

    private Map<Long, Lesson> lessonMap = new HashMap<>();

    public LesssonInMemory() {

        Lesson lesson1 = new Lesson();
        lesson1.setLessonId(1L);
        lesson1.setLessonName("Java");
        lesson1.setLessonNo("126746");

        Lesson lesson2 = new Lesson();
        lesson2.setLessonId(2L);
        lesson2.setLessonName("Programlama");
        lesson2.setLessonNo("98765434567");

        lessonMap.put(lesson1.getLessonId(), lesson1);
        lessonMap.put(lesson2.getLessonId(), lesson2);

    }

    public List<Lesson> findAll() {
        return new ArrayList<>(lessonMap.values());
    }

    public Lesson findById(Long id) {
        return lessonMap.get(id);
    }

    @Override
    public void lessonCreate(Lesson lesson) {
        lesson.setLessonId(new Date().getTime());
        lessonMap.put(lesson.getLessonId(), lesson);
    }
}

