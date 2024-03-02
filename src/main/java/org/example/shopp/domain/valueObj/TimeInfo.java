package org.example.shopp.domain.valueObj;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;

@Embeddable
@Data
public class TimeInfo {
    private LocalDateTime createdAd;
    private LocalDateTime updatedAd;
    private LocalDateTime deletedAd;


}
