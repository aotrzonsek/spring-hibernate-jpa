package pl.spring.demo.to;

import java.util.Set;

public class LibraryTo {
    private Long id;
    private String name;
    private AddressTo address;
    private Set<BookTo> books;
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressTo getAddress() {
        return address;
    }

    public void setAddress(AddressTo address) {
        this.address = address;
    }

    public Set<BookTo> getBooks() {
        return books;
    }

    public void setBooks(Set<BookTo> books) {
        this.books = books;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
