package practice.internet_lecture.course;

import java.time.OffsetDateTime;
import java.util.List;

public record CourseDetailResponseDto(
        String title,
        String description,
        Integer price,
        Integer numOfStudents,
        List<StudentResponseDto> studentsList,
        CourseCategory category,
        OffsetDateTime createdAt,
        OffsetDateTime LastUpdatedAt
) {
    public record StudentResponseDto(
            String nickname,
            OffsetDateTime registeredAt
    ) {}
}
