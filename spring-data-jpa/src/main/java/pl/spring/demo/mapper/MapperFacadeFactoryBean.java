package pl.spring.demo.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MapperFacadeFactoryBean implements FactoryBean<MapperFacade> {
    private final Set<MappingConfigurer> configurers;

    @Autowired(required = false)
    public MapperFacadeFactoryBean(Set<MappingConfigurer> configurers) {
        super();
        this.configurers = configurers;
    }

    @Override
    public MapperFacade getObject() throws Exception {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        for (MappingConfigurer configurer : configurers) {
            configurer.configure(mapperFactory);
        }

        return mapperFactory.getMapperFacade();

    }

    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
