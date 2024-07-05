package practice.internet_lecture.instructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instructor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // getter
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
