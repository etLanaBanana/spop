package org.example.shopp.domain.valueObj;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class FullName {
    private String firstName;
    private String secondName;
    private String lastName;
}
