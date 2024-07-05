package practice.internet_lecture.course;

import practice.internet_lecture.instructor.Instructor;

public record CourseCreateRequestDto(
        String title,
        String description,
        Long instructorId, // 모르겠음
        Integer price,
        CourseCategory category
) {

}
