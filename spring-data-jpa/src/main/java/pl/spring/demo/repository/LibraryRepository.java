package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long>, LibraryLambdaRepository {

    List<LibraryEntity> findByNameLike(String name);

    @Query("from LibraryEntity l where l.name like :name%")
    List<LibraryEntity> findByName(@Param("name") String name);

    @Query("from LibraryEntity l where l.address.city = :cityName")
    List<LibraryEntity> findByCity(@Param("cityName") String cityName);

    @Query("from LibraryEntity l where exists (select 1 from BookEntity b where b.library.id = l.id and b.title = :bookTitle)")
    List<LibraryEntity> findLibrariesThatHaveBookByTitle(@Param("bookTitle") String bookTitle);
}
