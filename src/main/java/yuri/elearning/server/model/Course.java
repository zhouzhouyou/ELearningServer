package yuri.elearning.server.model;

import lombok.Data;

@Data
public class Course {
    private Integer id;

    private String name;

    private String description;

    private String syllabus;

    private String teacher;

    private Double cost;

    private String cover;
}
