package mate.academy.springsecurity.service;

import mate.academy.springsecurity.dto.UserRegistrationRequestDto;
import mate.academy.springsecurity.dto.UserResponseDto;
import mate.academy.springsecurity.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(
            UserRegistrationRequestDto userRegistrationRequestDto) throws RegistrationException;
}
