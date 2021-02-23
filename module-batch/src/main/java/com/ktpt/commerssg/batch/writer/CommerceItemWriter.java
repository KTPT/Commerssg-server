package com.ktpt.commerssg.batch.writer;

import com.ktpt.commerssg.jpa.CommerceItemEntity;
import com.ktpt.commerssg.jpa.CommerceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommerceItemWriter implements ItemWriter<List<CommerceItemEntity>> {
    private final CommerceItemRepository commerceItemRepository;

    @Override
    public void write(List<? extends List<CommerceItemEntity>> items) {
        items.forEach(commerceItemRepository::saveAll);
    }
}
