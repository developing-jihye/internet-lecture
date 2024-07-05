package practice.internet_lecture.course;

import org.springframework.stereotype.Service;
import practice.internet_lecture.instructor.Instructor;
import practice.internet_lecture.instructor.InstructorRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class CourceService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourceService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    // 강의 등록
    public String create(CourseCreateRequestDto createRequestDto) {
        Instructor instructor = instructorRepository.findById(createRequestDto.instructorId())
                .orElseThrow(() -> new NoSuchElementException("해당 아이디의 강사가 없습니다."));

        Course newCourse = new Course(
                createRequestDto.title(),
                createRequestDto.description(),
                instructor,
                createRequestDto.price(),
                createRequestDto.category()
        );
        courseRepository.save(newCourse);
        return "강의 등록이 완료되었습니다.";
    }

    // 강의 상세 조회
    public CourseDetailResponseDto findById(Long courseId) {
        Course selectedCourse = courseRepository.findById(courseId).orElseThrow(
                () -> new NoSuchElementException("해당 아이디의 강의가 없습니다.")
        );

        return new CourseDetailResponseDto(
                selectedCourse.getTitle(),
                selectedCourse.getDescription(),
                selectedCourse.getPrice(),
                selectedCourse.getNumOfStudents(),
                new ArrayList<>(),
                selectedCourse.getCategory(),
                selectedCourse.getCreatedAt(),
                selectedCourse.getModifiedAt()
        );
    }

    // 강의 수정
    public String update(Long courseId, CourseUpdateRequestDto updateRequestDto) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new NoSuchElementException("해당 아이디의 강의가 없습니다.")
        );

        Course updatedCourse = new Course(
                updateRequestDto.title(),
                updateRequestDto.description(),
                course.getInstructor(),
                updateRequestDto.price(),
                course.getCategory()
        );

        courseRepository.save(updatedCourse);

        return "강의 정보 수정이 완료되었습니다.";
    }
}
