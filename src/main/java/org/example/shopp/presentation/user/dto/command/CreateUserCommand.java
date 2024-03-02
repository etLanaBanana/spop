package org.example.shopp.presentation.user.dto.command;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {
    private String firstName;
    private String secondName;
    private String lastName;
}
