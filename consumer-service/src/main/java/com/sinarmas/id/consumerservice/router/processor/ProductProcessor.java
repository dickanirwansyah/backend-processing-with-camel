package com.sinarmas.id.consumerservice.router.processor;

import com.sinarmas.id.consumerservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class ProductProcessor implements Processor {

    @Autowired
    private ProductService productService;

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("exchange filename is = {} ",exchange.getIn().getHeader(Exchange.FILE_NAME).toString());
        List<String> rows = new ArrayList<>();
        rows.addAll(Arrays.asList(exchange.getIn().getBody(String.class).split("\\r?\\n")));
        rows.remove(0);
        this.productService.saveProducts(rows);
        log.info("file data products process is completed..");
    }
}
