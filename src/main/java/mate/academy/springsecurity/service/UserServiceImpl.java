package mate.academy.springsecurity.service;

import lombok.RequiredArgsConstructor;
import mate.academy.springsecurity.dto.UserRegistrationRequestDto;
import mate.academy.springsecurity.dto.UserResponseDto;
import mate.academy.springsecurity.exception.RegistrationException;
import mate.academy.springsecurity.mapper.UserMapper;
import mate.academy.springsecurity.model.User;
import mate.academy.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto) {
        if (userRepository.existsByEmail(userRegistrationRequestDto.getEmail())) {
            throw new RegistrationException("User with email "
                    + userRegistrationRequestDto.getEmail()
                    + " already exists");
        }
        User user = userMapper.toEntity(userRegistrationRequestDto);
        userRepository.save(user);
        return userMapper.toResponseDto(user);
    }
}
