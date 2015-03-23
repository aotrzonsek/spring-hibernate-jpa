package pl.spring.demo.repository;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.searchcriteria.LibrarySearchCriteria;

import java.util.List;

/**
 * http://www.jinq.org/docs/jpa.html
 */
public interface LibraryLambdaRepository {

    List<LibraryEntity> findAllLibraries();
    LibraryEntity findLibraryById(long id);
    List<LibraryEntity> findLibrariesBySearchCriteria(LibrarySearchCriteria librarySearchCriteria);

}
