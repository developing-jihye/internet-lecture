package practice.internet_lecture.course;

import jakarta.persistence.*;
import practice.internet_lecture.instructor.Instructor;

import java.time.OffsetDateTime;

@Entity
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private Instructor instructor;

    private Integer price;

    private Integer numOfStudents;

    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    private OffsetDateTime createdAt;

    private OffsetDateTime modifiedAt;

    // constructors
    public Course() {
    }

    public Course(String title, String description, Instructor instructor, Integer price, CourseCategory category) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.price = price;
        this.category = category;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumOfStudents() {
        return numOfStudents;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }
}
