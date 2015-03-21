package pl.spring.demo.to;

import java.util.Set;

public abstract class PersonTo {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set<BookTo> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<BookTo> getBooks() {
        return books;
    }

    public void setBooks(Set<BookTo> books) {
        this.books = books;
    }
}
