package com.sinarmas.id.consumerservice.service;

import com.sinarmas.id.consumerservice.entity.Products;
import com.sinarmas.id.consumerservice.model.ValidationResponse;
import com.sinarmas.id.consumerservice.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public ValidationResponse saveProducts(List<String> rows){
        log.info("request save product = {} ",rows);
        rows.forEach(row -> {
            String[] columns = row.split(",");
            Products products = new Products();
            try{
                doSetProductCode(products,columns);
                doSetProductName(products, columns);
                doSetPrice(products, columns);
                doSetQty(products, columns);
                log.info("product = {} ",products);
                productsRepository.save(products);
            }catch (UnsupportedEncodingException e){
                log.error("error because invalid parse = {} ",e.getMessage());
            }
        });
        return ValidationResponse.builder()
                .valid(true)
                .build();
    }

    private void doSetProductCode(Products products, String[] columns) throws UnsupportedEncodingException {
        if (columns.length >= 1){
            String result = columns[0].replaceAll("^\"|\"$", "");
            products.setProductCode(result);
        }
    }

    private void doSetProductName(Products products, String[] columns) throws UnsupportedEncodingException {
        if (columns.length >=2){
            String result = columns[1].replaceAll("^\"|\"$", "");
            products.setName(result);
        }
    }

    private void doSetPrice(Products products, String[] columns) throws UnsupportedEncodingException {
        if (columns.length >= 3){
            products.setPrice(BigDecimal.ZERO);
        }
    }

    private void doSetQty(Products products, String[] columns) throws UnsupportedEncodingException {
        if (columns.length >=4){
            products.setQty(0);
        }
    }
}
