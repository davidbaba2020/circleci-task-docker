package com.example.projects.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserLoginRequest {
    private String email;
    private String password;
}
