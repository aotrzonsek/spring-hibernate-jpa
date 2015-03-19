package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.LibraryTo;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class LibraryServiceTest {

    @Autowired
    private LibraryService libraryService;

    @Test
    public void testShouldFindAllLibraries() {
        // given when
        List<LibraryTo> libraries = libraryService.findAllLibraries();
        // then
        assertNotNull(libraries);
    }

    @Test
    public void testShouldReturnLibraryByName() {
        // given
        final String libraryName = "Biblioteka Miejska";
        // when
        List<LibraryTo> libraries = libraryService.findAllLibrariesByName(libraryName);
        // then
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
        assertEquals(libraryName, libraries.get(0).getName());
    }

    @Test
    public void testShouldReturnLibrariesByCountryName() {
        // given
        final String cityName = "Wrocław";
        // when
        List<LibraryTo> libraries = libraryService.findAllLibrariesInCity(cityName);
        // then
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
    }

    @Test
    public void testShouldReturnLibrariesHavingGivenBook() {
        // given
        final String bookTitle = "Sample Book";
        // when
        List<LibraryTo> libraries = libraryService.findLibrariesThatHaveBookByTitle(bookTitle);
        // then
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
        for (LibraryTo library : libraries) {
            assertLibraryHasBook(library, bookTitle);
        }
    }

    private void assertLibraryHasBook(LibraryTo library, String bookTitle) {
        boolean hasBook = false;
        for (BookTo book : library.getBooks()) {
            if (bookTitle != null && bookTitle.equals(book.getTitle())) {
                hasBook = true;
                break;
            }
        }
        assertTrue("Library doen't have a book", hasBook);
    }
}
