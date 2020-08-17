package src.main.model;


import java.io.Serializable;


@Entity
@Table(name ="Lesson")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;
    @Column(name = "lesson_no", nullable = false)
    private String lessonNo;
    @Column(name = "lessonName", nullable = false)
    private String lessonName;

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(String lessonNo) {
        this.lessonNo = lessonNo;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }



}