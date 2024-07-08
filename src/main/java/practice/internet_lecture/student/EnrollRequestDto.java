package practice.internet_lecture.student;

import practice.internet_lecture.course.Course;

public record EnrollRequestDto(
        Long studentId,
        Long courseId
) {
}
