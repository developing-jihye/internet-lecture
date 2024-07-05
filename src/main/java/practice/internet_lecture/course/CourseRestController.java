package practice.internet_lecture.course;

import org.springframework.web.bind.annotation.*;

@RestController
public class CourseRestController {
    private final CourceService courceService;

    public CourseRestController(CourceService courceService) {
        this.courceService = courceService;
    }

    // 강의 등록
    @PostMapping("/courses")
    public String create(@RequestBody CourseCreateRequestDto courseCreateRequestDto) {
        return courceService.create(courseCreateRequestDto);
    }

    // 강의 목록 조회


    // 강의 상세 조회
    @GetMapping("/courses/{courseId}")
    public CourseDetailResponseDto findById(@PathVariable Long courseId) {
        return courceService.findById(courseId);
    }
}
