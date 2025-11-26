package mate.academy.springsecurity.mapper;

import mate.academy.springsecurity.dto.UserRegistrationRequestDto;
import mate.academy.springsecurity.dto.UserResponseDto;
import mate.academy.springsecurity.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegistrationRequestDto user);

    UserResponseDto toResponseDto(User user);
}
