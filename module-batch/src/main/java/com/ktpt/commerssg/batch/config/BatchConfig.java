package com.ktpt.commerssg.batch.config;

import com.ktpt.commerssg.batch.processor.CommerceItemProcessor;
import com.ktpt.commerssg.batch.reader.NaverCommerceItemReader;
import com.ktpt.commerssg.batch.writer.CommerceItemWriter;
import com.ktpt.commerssg.common.domain.model.CommerceItem;
import com.ktpt.commerssg.jpa.CommerceItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RequiredArgsConstructor
@EnableBatchProcessing
@Configuration
public class BatchConfig {
    private static final int CHUNK_SIZE = 1;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final NaverCommerceItemReader naverCommerceItemReader;
    private final CommerceItemProcessor commerceItemProcessor;
    private final CommerceItemWriter commerceItemWriter;

    @Bean
    public Job commerceJob() {
        return jobBuilderFactory.get("commerceJob")
                .start(findNaverCommerceItem())
                .build();
    }

    @Bean
    public Step findNaverCommerceItem() {
        return stepBuilderFactory.get("findNaverCommerceItem")
                .<List<CommerceItem>, List<CommerceItemEntity>>chunk(CHUNK_SIZE)
                .reader(naverCommerceItemReader)
                .processor(commerceItemProcessor)
                .writer(commerceItemWriter)
                .build();
    }
}
