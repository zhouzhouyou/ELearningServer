package yuri.elearning.server.model;

import lombok.Data;

@Data
public class CoursePartMessage {
    private String name;

    private Integer id;

    private String cover;

    public CoursePartMessage(String name,Integer id, String cover) {
        this.id = id;
        this.cover = cover;
    }
}
