package com.example.projects.Dto;

import lombok.*;

import javax.persistence.Column;
import java.time.Instant;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
