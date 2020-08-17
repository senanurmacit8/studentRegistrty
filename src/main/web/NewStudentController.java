package src.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import src.main.model.Student;
import src.main.service.MainService;

@RestController
public class NewStudentController {

    @Autowired
    private Student student;

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/student/new", method = RequestMethod.GET)
    public String newLesson() {
        return "newStudent";
    }


    @ModelAttribute
    public Student initModel() {
        return new Student();
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.POST)
    public String handleFormSubmit(@ModelAttribute Student student) {
        mainService.createStudent(student);
        return "redirect:/St";
    }

}
