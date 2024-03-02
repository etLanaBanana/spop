package org.example.shopp.presentation.user.dto.query;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserQuery {
    private String firstName;
    private String secondName;
    private LocalDateTime cratedAt = LocalDateTime.now();
}
