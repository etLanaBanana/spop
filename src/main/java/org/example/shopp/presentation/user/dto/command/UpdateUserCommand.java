package org.example.shopp.presentation.user.dto.command;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserCommand {
    private String firstName;
    private String secondName;
    private String lastName;
}
