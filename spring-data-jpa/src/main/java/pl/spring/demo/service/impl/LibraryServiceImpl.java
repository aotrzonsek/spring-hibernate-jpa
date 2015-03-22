package pl.spring.demo.service.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.repository.LibraryRepository;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private MapperFacade mapper;

    @Override
    public List<LibraryTo> findAllLibraries() {
        List<LibraryEntity> libraries = libraryRepository.findAll();
        return mapper.mapAsList(libraries, LibraryTo.class);
    }

    @Override
    public List<LibraryTo> findAllLibrariesByName(String name) {
        List<LibraryEntity> libraries = libraryRepository.findByName(name);
        return mapper.mapAsList(libraries, LibraryTo.class);
    }

    @Override
    public List<LibraryTo> findAllLibrariesInCity(String cityName) {
        List<LibraryEntity> libraries = libraryRepository.findByCity(cityName);
        return mapper.mapAsList(libraries, LibraryTo.class);
    }

    @Override
    public List<LibraryTo> findLibrariesThatHaveBookByTitle(String bookTitle) {
        List<LibraryEntity> libraries = libraryRepository.findLibrariesThatHaveBookByTitle(bookTitle);
        return mapper.mapAsList(libraries, LibraryTo.class);
    }

    @Override
    @Transactional(readOnly = false)
    public LibraryTo saveOrUpdateLibrary(LibraryTo library) {
        LibraryEntity libraryEntity = mapper.map(library, LibraryEntity.class);
        libraryEntity = libraryRepository.save(libraryEntity);
        return mapper.map(libraryEntity, LibraryTo.class);
    }
}
