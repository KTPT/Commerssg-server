package com.ktpt.commerssg.batch.processor;

import com.ktpt.commerssg.common.domain.model.CommerceItem;
import com.ktpt.commerssg.jpa.CommerceItemEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommerceItemProcessor implements ItemProcessor<List<CommerceItem>, List<CommerceItemEntity>> {
    @Override
    public List<CommerceItemEntity> process(List<CommerceItem> item) {
        return item.stream()
                .map(it -> new CommerceItemEntity(null, it.getTitle(), it.getPlatform(), it.getThumbnail(), it.getOriginalPrice(), it.getSellingPrice(), it.getDiscountRate(), LocalDateTime.now(), LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
