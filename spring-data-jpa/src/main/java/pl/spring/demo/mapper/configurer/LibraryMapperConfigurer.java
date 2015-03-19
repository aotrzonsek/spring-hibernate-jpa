package pl.spring.demo.mapper.configurer;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.mapper.MappingConfigurer;
import pl.spring.demo.to.LibraryTo;

@Component
public class LibraryMapperConfigurer implements MappingConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(LibraryEntity.class, LibraryTo.class).byDefault().register();
    }
}
