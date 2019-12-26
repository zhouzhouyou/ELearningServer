package yuri.elearning.server.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel
@Data
@AllArgsConstructor
public class CourseBriefInfo {
    private String name;

    private Integer id;

    private String cover;
}
