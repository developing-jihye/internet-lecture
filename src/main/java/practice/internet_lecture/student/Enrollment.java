package practice.internet_lecture.student;

import jakarta.persistence.*;
import practice.internet_lecture.course.Course;

import java.time.OffsetDateTime;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private OffsetDateTime enrolledAt;

    // constructors
    public Enrollment() {
    }

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
