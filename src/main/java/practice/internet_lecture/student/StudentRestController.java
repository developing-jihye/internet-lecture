package practice.internet_lecture.student;

import org.springframework.web.bind.annotation.PutMapping;
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
}
