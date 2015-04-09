package pl.spring.demo.dao;

import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

public interface LibraryDao extends Dao<LibraryEntity> {

    List<LibraryEntity> findByName(String name);
    List<LibraryEntity> findByCity(String cityName);
    List<LibraryEntity> findLibrariesThatHaveBookByTitle(String bookTitle);
}
