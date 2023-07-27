package com.sinarmas.id.consumerservice.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
public class CommonUtil {

    public String cleanString(String value) throws UnsupportedEncodingException {
        String trimmed = value.trim();
        if (validateNullable(trimmed)) return null;
        byte[] utf8 = trimmed.getBytes(StandardCharsets.UTF_8);
        byte[] latin1 = trimmed.getBytes(StandardCharsets.ISO_8859_1);
        String errorMessage = String.format("Failed convert [%] cannot compatible with UTF-8", trimmed);
        if (!Arrays.equals(utf8, latin1)) throw new UnsupportedEncodingException(errorMessage);
        return trimmed;
    }

    private boolean validateNullable(String decimal){
        return StringUtils.isEmpty(decimal) || decimal.equalsIgnoreCase("null");
    }
}
