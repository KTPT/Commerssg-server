package com.ktpt.commerssg.batch.reader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktpt.commerssg.common.domain.model.CommerceItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class NaverCommerceItemReader implements ItemReader<List<CommerceItem>> {
    private final ObjectMapper objectMapper;
    // TODO: 2021/02/23 finish 개선
    private boolean isSuccess = false;

    @Override
    public List<CommerceItem> read() {
        if (isSuccess) {
            return null;
        }
        List<CommerceItem> response = WebClient.create().get()
                .uri("https://apis.naver.com/selectiveweb/selectiveweb/v1/home/live-now")
                .retrieve()
                .bodyToMono(String.class)
                .map(this::toCommerceItemList)
                .block();
        if (!Objects.requireNonNull(response).isEmpty()) {
            isSuccess = true;
            return response;
        }
        throw new RuntimeException();
    }

    private List<CommerceItem> toCommerceItemList(String json) {
        try {
            List<Map<String, String>> list = (List<Map<String, String>>) objectMapper.readValue(json, Map.class).get("list");
            return list.stream()
                    .map(CommerceItem::naverOf)
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
