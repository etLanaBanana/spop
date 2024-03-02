package org.example.shopp.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.shopp.domain.valueObj.TimeInfo;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Embedded
    private TimeInfo timeInfo;

    @PrePersist
    public void prePersist() {
        if (timeInfo == null) {
            timeInfo = new TimeInfo();
        }
        timeInfo.setCreatedAd(LocalDateTime.now());
    }

}
