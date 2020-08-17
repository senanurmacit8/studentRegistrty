package src.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import src.main.exceptionHandler.MaxStudentQuataFailed;
import src.main.model.Lesson;
import src.main.model.Student;
import src.main.service.MainService;

@RestController
public class Controller {

    private int maxQuota = 100;

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/addLessonToStudent", method = RequestMethod.GET)
    public ModelAndView addLessonToStudent(@PathVariable("id") Long id, @PathVariable("lesson") Lesson selectedLesson) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = mainService.findStudent(id);

        Number count = mainService.findStudents().parallelStream().filter(s -> s.getLesson().equals(selectedLesson)).count();

        if (count.intValue() <= maxQuota) {
            modelAndView.addObject("Students", student.getLesson());
            mainService.studentUpdate(student);
        } else {
            throw new MaxStudentQuataFailed("Maximum kontenjana ulaşıldı. \n Maksimum kontanjan sayısı : " + maxQuota);
        }

        modelAndView.setViewName("St");
        return modelAndView;
    }

    @RequestMapping(value = "/allLesson", method = RequestMethod.GET)
    public ModelAndView getAllLessons() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Lesson", "Java");
        modelAndView.setViewName("Lessons");
        return modelAndView;
    }

}