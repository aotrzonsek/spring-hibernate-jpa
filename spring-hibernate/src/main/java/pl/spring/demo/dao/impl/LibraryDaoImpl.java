package pl.spring.demo.dao.impl;

import org.springframework.stereotype.Repository;
import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

@Repository
public class LibraryDaoImpl extends AbstractDao<LibraryEntity> implements LibraryDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<LibraryEntity> findByName(String name) {
        return getSession().createQuery("from LibraryEntity l where l.name like :name").setString("name", name + "%").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LibraryEntity> findByCity(String cityName) {
        return getSession().createQuery("from LibraryEntity l where l.address.city = :cityName").setString("cityName", cityName).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LibraryEntity> findLibrariesThatHaveBookByTitle(String bookTitle) {
        return getSession().createQuery("from LibraryEntity l where exists " +
                "(select 1 from BookEntity b where b.library.id = l.id and b.title = :bookTitle)")
                .setString("bookTitle", bookTitle).list();
    }
}
