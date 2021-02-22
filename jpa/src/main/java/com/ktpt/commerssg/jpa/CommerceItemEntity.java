package com.ktpt.commerssg.jpa;

import com.ktpt.commerssg.common.domain.model.CommerceItem;
import com.ktpt.commerssg.common.domain.model.Platform;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommerceItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Platform platform;
    private String thumbnail;
    private Integer originalPrice;
    private Integer sellingPrice;
    private Double discountRate;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static CommerceItemEntity toEntity(CommerceItem commerceItem) {
        return new CommerceItemEntity(null, commerceItem.getTitle(), commerceItem.getPlatform(), commerceItem.getThumbnail(), commerceItem.getOriginalPrice(), commerceItem.getSellingPrice(), commerceItem.getDiscountRate(), null, null);
    }
}
