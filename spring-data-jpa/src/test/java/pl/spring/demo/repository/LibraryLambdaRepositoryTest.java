package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.searchcriteria.LibrarySearchCriteria;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryLambdaRepositoryTest {

    @Autowired
    @Qualifier("libraryRepository")
    private LibraryLambdaRepository libraryLambdaRepository;

    @Test
    public void testShouldReturnAllLibraries() {
        // given when
        List<LibraryEntity> allLibraries = libraryLambdaRepository.findAllLibraries();
        // then
        assertNotNull(allLibraries);
        assertFalse(allLibraries.isEmpty());
    }

    @Test
    public void testShouldFindLibraryById() {
        // given
        final long id = 1;
        // when
        LibraryEntity library = libraryLambdaRepository.findLibraryById(id);
        // then
        assertNotNull(library);
        assertEquals(id, library.getId().longValue());
    }

    @Test
    public void testShouldNotFindLibraryById() {
        // given
        final long id = -1;
        // when
        LibraryEntity library = libraryLambdaRepository.findLibraryById(id);
        // then
        assertNull(library);
    }

    @Test
    public void testShouldReturnLibraryByBookSearchCriteria() {
        // given
        String bookTitle = "Sample Book";
        LibrarySearchCriteria searchCriteria = new LibrarySearchCriteria.LibrarySearchCriteriaBuilder().withBook(bookTitle).build();
        // when
        List<LibraryEntity> libraries = libraryLambdaRepository.findLibrariesBySearchCriteria(searchCriteria);
        // then
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
        assertEquals(1, libraries.size());
    }
}
