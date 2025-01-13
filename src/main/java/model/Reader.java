package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("readers")
public class Reader {
    @Id
    private Long id;
    private String name;
    private String email;

}
