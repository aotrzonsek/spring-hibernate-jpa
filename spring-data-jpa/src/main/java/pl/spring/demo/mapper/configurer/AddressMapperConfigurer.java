package pl.spring.demo.mapper.configurer;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.AddressEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.mapper.MappingConfigurer;
import pl.spring.demo.to.AddressTo;
import pl.spring.demo.to.LibraryTo;

@Component
public class AddressMapperConfigurer implements MappingConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(AddressEntity.class, AddressTo.class).byDefault().register();
    }
}
