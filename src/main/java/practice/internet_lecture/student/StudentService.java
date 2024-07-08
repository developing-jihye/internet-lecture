package practice.internet_lecture.student;

import org.springframework.stereotype.Service;
import practice.internet_lecture.course.Course;
import practice.internet_lecture.course.CourseRepository;

import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    // 회원 가입
    public String create(StudentCreateRequestDto createRequestDto) {
        Student newStudent = new Student(createRequestDto.email(), createRequestDto.nickname());
        studentRepository.save(newStudent);
        return "회원 가입이 완료되었습니다.";
    }

    // 수강 신청
    public String enroll(EnrollRequestDto requestDto) {
        // 학생 ID가 null인지 확인
        if (requestDto.studentId() == null) {
            throw new IllegalArgumentException("학생 ID가 null입니다.");
        }

        // 강의 ID가 null인지 확인
        if (requestDto.courseId() == null) {
            throw new IllegalArgumentException("강의 ID가 null입니다.");
        }

        Student student = studentRepository.findById(requestDto.studentId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디의 학생이 없습니다.")
        );

        Course course = courseRepository.findById(requestDto.courseId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디의 강의가 없습니다.")
        );

        Enrollment newEnrollment = new Enrollment(student, course);
        enrollmentRepository.save(newEnrollment);
        return "수강신청이 완료되었습니다.";
    }
}
