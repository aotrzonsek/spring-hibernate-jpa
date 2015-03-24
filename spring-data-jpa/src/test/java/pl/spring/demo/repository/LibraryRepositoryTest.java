package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void testShouldFindLibraryByName() {
        // given
        final String libraryName = "Biblioteka M";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByName(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
    }

    @Test
    public void testShouldFindLibraryByNameLike() {
        // given
        final String libraryName = "Biblioteka M%";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByNameLike(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
    }
}
