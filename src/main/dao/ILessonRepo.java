package src.main.dao;

import src.main.model.Lesson;
import src.main.model.Student;

import java.util.List;

public interface ILessonRepo {

    List<Lesson> findAll();

    void lessonCreate(Lesson lesson);
}
