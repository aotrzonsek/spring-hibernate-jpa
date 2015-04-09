package pl.spring.demo.mapper.configurer;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.PersonEntity;
import pl.spring.demo.mapper.MappingConfigurer;
import pl.spring.demo.to.PersonTo;

@Component
public class PersonMapperConfigurer implements MappingConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(PersonEntity.class, PersonTo.class).byDefault().register();
    }
}
