package pl.spring.demo.searchcriteria;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LibrarySearchCriteria implements Serializable {

    private Long id;
    private String name;
    private Set<String> anyBook = new HashSet<>();

    private LibrarySearchCriteria() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAnyBook() {
        return new HashSet<>(anyBook);
    }

    public static class LibrarySearchCriteriaBuilder {
        private LibrarySearchCriteria librarySearchCriteria = new LibrarySearchCriteria();

        public LibrarySearchCriteriaBuilder witId(long id) {
            librarySearchCriteria.id = id;
            return this;
        }

        public LibrarySearchCriteriaBuilder withName(String name) {
            librarySearchCriteria.name = name;
            return this;
        }

        public LibrarySearchCriteriaBuilder withBook(String bookTitile) {
            librarySearchCriteria.anyBook.add(bookTitile);
            return this;
        }

        public LibrarySearchCriteria build() {
            return librarySearchCriteria;
        }
    }
}
