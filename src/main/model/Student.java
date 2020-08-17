package src.main.model;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name ="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Column(name = "student_no", nullable = false)
    private String studentNo;
    @Column(name = "student_name", nullable = false)
    private String studentName;
    @Column(name = "student_lastname", nullable = false)
    private String studentLastname;
    @OneToMany(targetEntity=Lesson.class ,fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson", referencedColumnName = "lesson", nullable = false)
    private Lesson lesson;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }


}
}