package practice.internet_lecture.course;

import practice.internet_lecture.student.Student;

public record EnrollRequestDto(
        Student student,
        Course course
) {
}
