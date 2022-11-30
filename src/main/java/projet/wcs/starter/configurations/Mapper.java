package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dao.*;
import projet.wcs.starter.dto.*;

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
        TypeMap<Reservation, ReservationDto> propertyReservation = modelMapper.createTypeMap(Reservation.class, ReservationDto.class);
        propertyReservation.addMappings(
                mapping -> {
                    mapping.map(Reservation::getCommand,ReservationDto::setCommand);
                    mapping.map(source -> source.getRestaurantTable().getId(), ReservationDto::setRestaurantTableId);
                }
        );
        TypeMap<RestaurantTable, RestaurantTableDto> propertyTable = modelMapper.createTypeMap(RestaurantTable.class, RestaurantTableDto.class);
        propertyTable.addMappings(
                mapping -> mapping.map(RestaurantTable::getReservations,RestaurantTableDto::setReservations)
        );
        TypeMap<Command, CommandDto> propertyCommand = modelMapper.createTypeMap(Command.class, CommandDto.class);
        propertyCommand.addMappings(
                mapping -> mapping.map(Command::getComments,CommandDto::setComments)
        );
        TypeMap<Comment, CommentDto> propertyComment = modelMapper.createTypeMap(Comment.class, CommentDto.class);
        propertyComment.addMappings(
                mapping -> mapping.map(source -> source.getCommand().getId(), CommentDto::setCommandId)
        );
        TypeMap<User, UserDto> propertyUser = modelMapper.createTypeMap(User.class, UserDto.class);
        propertyUser.addMappings(
                mapping -> {
                    mapping.map(source -> source.getRestaurant().getId(), UserDto::setRestaurantId);
                    mapping.map(User::getRoles, UserDto::setRoles);
                }
        );
        TypeMap<Restaurant, RestaurantDto> propertyRestaurant = modelMapper.createTypeMap(Restaurant.class, RestaurantDto.class);
        propertyRestaurant.addMappings(
                mapping -> mapping.map(Restaurant::getUsers, RestaurantDto::setUsers)
        );

        return modelMapper;
    }
}
