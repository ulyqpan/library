package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("books")
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private int availableCopies;

    public int getAvailableCopies() {
    }

    public void setAvailableCopies(int i) {

    }
}
