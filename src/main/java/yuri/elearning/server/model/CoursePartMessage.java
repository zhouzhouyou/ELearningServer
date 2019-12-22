package yuri.elearning.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoursePartMessage {
    private String name;

    private Integer id;

    private String cover;
}
