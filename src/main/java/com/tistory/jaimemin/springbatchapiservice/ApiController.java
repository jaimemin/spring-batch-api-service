package com.tistory.jaimemin.springbatchapiservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ApiController {

    /**
     * id마다 별도 서버라고 가정
     *
     * @param id
     * @param apiInfo
     * @return
     */
    @PostMapping("/api/product/{id}")
    public String product(@PathVariable Long id, @RequestBody ApiInfo apiInfo) {
        List<ProductVO> productVOs = apiInfo.getApiRequests().stream()
                .map(item -> item.getProductVO())
                .collect(Collectors.toList());

        log.info("productVOs = {}", productVOs);

        return String.format("product%d was successfully processed", id);
    }
}
