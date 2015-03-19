package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spring.demo.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
