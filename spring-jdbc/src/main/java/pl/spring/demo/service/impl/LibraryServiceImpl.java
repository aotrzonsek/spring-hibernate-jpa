package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import pl.spring.demo.rowmapper.LibraryRowMapper;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

import java.util.HashMap;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private static final String FIND_ALL_LIBRARIES_SQL =
            "select id, name, address_id from Library";
    private static final String FIND_ALL_LIBRARIES_BY_NAME_SQL =
            "select id, name, address_id from Library where name = :name";
    private static final String FIND_ALL_LIBRARIES_IN_CITY_SQL =
            "select l.id, l.name, l.address_id from Library l, Address a where l.address_id = a.id and a.city = :city";
    private static final String FIND_ALL_LIBRARIES_HAVING_BOOK_SQL =
            "select l.id, l.name, l.address_id from Library l where exists (Select 1 from Book b where b.library_id = l.id and b.title like :title)";

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;
    @Autowired
    private LibraryRowMapper libraryRowMapper;

    @Override
    public List<LibraryTo> findAllLibraries() {
        return jdbcTemplate.query(FIND_ALL_LIBRARIES_SQL, new HashMap<String, Object>(), libraryRowMapper);
    }

    @Override
    public List<LibraryTo> findAllLibrariesByName(String name) {
        SqlParameterSource params = new MapSqlParameterSource("name", name);
        return jdbcTemplate.query(FIND_ALL_LIBRARIES_BY_NAME_SQL, params, libraryRowMapper);
    }

    @Override
    public List<LibraryTo> findAllLibrariesInCity(String cityName) {
        SqlParameterSource params = new MapSqlParameterSource("city", cityName);
        return jdbcTemplate.query(FIND_ALL_LIBRARIES_IN_CITY_SQL, params, libraryRowMapper);
    }

    @Override
    public List<LibraryTo> findLibrariesThatHaveBookByTitle(String bookTitle) {
        SqlParameterSource params = new MapSqlParameterSource("title", bookTitle);
        return jdbcTemplate.query(FIND_ALL_LIBRARIES_HAVING_BOOK_SQL, params, libraryRowMapper);
    }
}
