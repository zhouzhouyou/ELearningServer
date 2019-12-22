package yuri.elearning.server.model;

import lombok.Data;

@Data
public class CategoryPartMessage {
    private String name;

    private Integer id;

    public CategoryPartMessage(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
