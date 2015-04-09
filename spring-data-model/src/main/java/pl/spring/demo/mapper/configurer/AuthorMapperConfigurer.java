package pl.spring.demo.mapper.configurer;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.mapper.MappingConfigurer;
import pl.spring.demo.to.AuthorTo;

@Component
public class AuthorMapperConfigurer implements MappingConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(AuthorEntity.class, AuthorTo.class).byDefault().register();
    }
}
