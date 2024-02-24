package com.proyecto.ReadRift.dtos.UserDto;

import com.proyecto.ReadRift.models.user.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
public class UserRequestDto {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final Role role;
}
