package pl.spring.demo.mapper.configurer;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.MappingConfigurer;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

@Component
public class BookMapperConfigurer implements MappingConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(BookEntity.class, BookTo.class).byDefault().register();
    }
}
