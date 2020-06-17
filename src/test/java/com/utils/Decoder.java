package com.utils;

import java.util.Base64;

public class Decoder {

    private static final Base64.Decoder decode = Base64.getDecoder();

    static String decodes(String code) {

        return new String(decode.decode(code));
    }


}
