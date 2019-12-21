package yuri.elearning.server.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private String password;

    private Double money;
}
