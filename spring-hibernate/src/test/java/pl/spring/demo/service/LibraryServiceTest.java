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
    public void testShouldReturnLibrariesByCityName() {
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

    @Test
    public void testShouldSaveNewLibrary() {
        // given
        final String libraryName = "NewLibrary";
        LibraryTo library = new LibraryTo();
        library.setName(libraryName);
        // when
        libraryService.saveOrUpdateLibrary(library);
        // then
        List<LibraryTo> librariesByName = libraryService.findAllLibrariesByName(libraryName);
        assertNotNull(librariesByName);
        assertFalse(librariesByName.isEmpty());
    }

    @Test
    public void testShouldUpdateLibrary() {
        // given
        final String currentLibraryName = "Biblioteka Rynek";
        final String newLibraryName = "NewLibraryName";
        LibraryTo library = libraryService.findAllLibrariesByName(currentLibraryName).get(0);
        library.setName(newLibraryName);
        // when
        libraryService.saveOrUpdateLibrary(library);
        // then
        List<LibraryTo> librariesByOldName = libraryService.findAllLibrariesByName(currentLibraryName);
        assertNotNull(librariesByOldName);
        assertTrue(librariesByOldName.isEmpty());

        List<LibraryTo> librariesByNewName = libraryService.findAllLibrariesByName(newLibraryName);
        assertNotNull(librariesByNewName);
        assertFalse(librariesByNewName.isEmpty());
    }

    @Test(expected = org.springframework.orm.ObjectOptimisticLockingFailureException.class)
    public void testShouldThrowOptimisticLockingExceptionOnLibraryUpdate() {
        // given
        final String libraryName = "Biblioteka Rynek";
        LibraryTo library = libraryService.findAllLibrariesByName(libraryName).get(0);
        library.setVersion(0);
        // when
        libraryService.saveOrUpdateLibrary(library);
        // then
        fail("should throw OptimisticLockingException");
    }

    private void assertLibraryHasBook(LibraryTo library, String bookTitle) {
        boolean hasBook = false;
        for (BookTo book : library.getBooks()) {
            if (bookTitle != null && bookTitle.equals(book.getTitle())) {
                hasBook = true;
                break;
            }
        }
        assertTrue("Library doesn't have a book", hasBook);
    }
}
