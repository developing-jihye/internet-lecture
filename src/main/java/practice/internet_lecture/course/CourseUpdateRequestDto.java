package practice.internet_lecture.course;

public record CourseUpdateRequestDto(
        String title,
        String description,
        Integer price
) {
}
