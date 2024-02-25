package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.UserDto.UserRequestDto;
import com.proyecto.ReadRift.dtos.UserDto.UserResponseDto;
import com.proyecto.ReadRift.models.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    public User toModel(UserRequestDto userDTO) {
        return new User(
                null,
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }
    public User toModel(Long userId) {
        return new User(
                userId,
              null,
                null,
                null,
                null,
                null
        );
    }
}
