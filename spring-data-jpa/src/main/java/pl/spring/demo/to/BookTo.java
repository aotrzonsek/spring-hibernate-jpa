package pl.spring.demo.to;

import java.util.Set;

public class BookTo {
    private long id;
    private String title;
    private Set<AuthorTo> authors;
    private LibraryTo library;

    // for hibernate
    protected BookTo() {
    }

    public BookTo(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<AuthorTo> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorTo> authors) {
        this.authors = authors;
    }
}
