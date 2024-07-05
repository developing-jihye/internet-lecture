package practice.internet_lecture.student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 회원 가입
    public String create(StudentCreateRequestDto createRequestDto) {
        Student newStudent = new Student(createRequestDto.email(), createRequestDto.nickname());
        studentRepository.save(newStudent);
        return "회원 가입이 완료되었습니다.";
    }
}
