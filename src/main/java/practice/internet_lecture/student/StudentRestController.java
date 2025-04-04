package practice.internet_lecture.student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 회원가입
    @PutMapping("/students")
    public String create(StudentCreateRequestDto createRequestDto) {
        return studentService.create(createRequestDto);
    }

    // 수강신청
    @PostMapping("/enrollments")
    public String enroll(@RequestBody EnrollRequestDto requestDto) {
        return studentService.enroll(requestDto);
    }
}
