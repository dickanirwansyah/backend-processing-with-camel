package com.sinarmas.id.consumerservice.router;

import com.sinarmas.id.consumerservice.router.processor.ProductProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductRouter extends AbstractRouter {

    @Autowired
    private ProductProcessor productProcessor;

    @Override
    public void configure() throws Exception {
        log.info("ProductRouter is already..");
        from("file:C:\\Users\\Muhammad Dicka\\Documents\\dummy-folder?"+
                "preMove=processing"+
                "&readLock=changed"+
                "&moveFailed=C:\\Users\\Muhammad Dicka\\Documents\\dummy-folder\\error\\${file:name}"+
                "&move=C:\\Users\\Muhammad Dicka\\Documents\\dummy-folder\\success\\${file:name}")
                .delay(delayProcess)
                .process(productProcessor);
    }
}
