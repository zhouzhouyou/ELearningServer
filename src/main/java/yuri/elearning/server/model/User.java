package yuri.elearning.server.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("用户")
@Data
public class User {
    private Integer id;

    private String name;

    private String password;

    private Double money;
}
