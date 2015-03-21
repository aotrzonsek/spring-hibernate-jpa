package pl.spring.demo.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.spring.demo.to.AddressTo;
import pl.spring.demo.to.LibraryTo;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class LibraryRowMapper implements RowMapper<LibraryTo> {

    @Override
    public LibraryTo mapRow(ResultSet rs, int rowNum) throws SQLException {
        LibraryTo library = new LibraryTo();
        library.setId(rs.getLong(1));
        library.setName(rs.getString(2));
        library.setAddress(mapAddressById(rs.getLong(3)));
        return library;
    }

    private AddressTo mapAddressById(Long addressId) {
        if (addressId != null && Long.compare(0, addressId) != 0) {
            return new AddressTo(addressId);
        }
        return null;
    }
}
