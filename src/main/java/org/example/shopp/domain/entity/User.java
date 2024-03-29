package org.example.shopp.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.shopp.domain.valueObj.FullName;
import org.example.shopp.domain.valueObj.TimeInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends FullName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Embedded
    private TimeInfo timeInfo;

    @OneToOne(mappedBy = "user")
    private History histories;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @PrePersist
    public void prePersist() {
        if (timeInfo == null) {
            timeInfo = new TimeInfo();
        }
        timeInfo.setCreatedAd(LocalDateTime.now());
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }
}