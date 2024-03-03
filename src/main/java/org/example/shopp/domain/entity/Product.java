package org.example.shopp.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.shopp.domain.valueObj.TimeInfo;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private History history;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

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