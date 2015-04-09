package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testShouldFindAuthorById() {
        // given
        final long id = 1;
        // when
        AuthorEntity authorEntity = authorRepository.findOne(id);
        // then
        assertNotNull(authorEntity);
    }
}
