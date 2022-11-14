package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dao.Category;
import projet.wcs.starter.dao.Command;
import projet.wcs.starter.dao.Item;
import projet.wcs.starter.dao.Reservation;
import projet.wcs.starter.dto.CategoryDto;
import projet.wcs.starter.dto.CommandDto;
import projet.wcs.starter.dto.ItemDto;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Item, ItemDto> propertyItem = modelMapper.createTypeMap(Item.class, ItemDto.class);
        propertyItem.addMappings(
                mapping -> mapping.map(source -> source.getCategory().getId(), ItemDto::setCategoryId)
        );

        TypeMap<Category, CategoryDto> propertyCategory = modelMapper.createTypeMap(Category.class, CategoryDto.class);
        propertyCategory.addMappings(
                mapping -> mapping.map(Category::getItems, CategoryDto::setItems)
        );

        return modelMapper;
    }
}
