package pl.spring.demo.repository.impl;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JPQL;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.repository.LibraryLambdaRepository;
import pl.spring.demo.searchcriteria.LibrarySearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryLambdaRepository {

    @PersistenceContext(name = "hsql")
    private EntityManager entityManager;
    @Autowired
    private JinqJPAStreamProvider jinqJPAStreamProvider;

    @Override
    public List<LibraryEntity> findAllLibraries() {
        return jinqJPAStreamProvider.streamAll(entityManager, LibraryEntity.class).toList();
    }

    @Override
    public LibraryEntity findLibraryById(long id) {
        JPAJinqStream<LibraryEntity> stream = jinqJPAStreamProvider.streamAll(entityManager, LibraryEntity.class).where(l -> l.getId() == id);
        if (stream.count() == 1) {
            return stream.getOnlyValue();
        }
        return null;
    }

    @Override
    public List<LibraryEntity> findLibrariesBySearchCriteria(LibrarySearchCriteria librarySearchCriteria) {
        JPAJinqStream<LibraryEntity> stream = jinqJPAStreamProvider.streamAll(entityManager, LibraryEntity.class);
        if (librarySearchCriteria.getId() != null) {
            Long libraryId = librarySearchCriteria.getId();
            stream = stream.where(l -> l.getId() == libraryId);
        }
        if (librarySearchCriteria.getName() != null) {
            String libraryName = librarySearchCriteria.getName();
            stream = stream.where(l -> l.getName().equals(libraryName));
        }
        if (!librarySearchCriteria.getAnyBook().isEmpty()) {
            List<String> lambdaParameter = new ArrayList<>(librarySearchCriteria.getAnyBook());
            stream = stream.where((l, source) -> JPQL.listContains(lambdaParameter, source.stream(BookEntity.class).where(b -> b.getLibrary()
                    .getId() == l.getId()).select(b -> b.getTitle()).getOnlyValue()));
        }
        return stream.toList();
    }


}
