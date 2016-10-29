package com.example.securityangular.models.serializers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class GrantedAuthorityToStringConverter implements Converter<GrantedAuthority, String> {

    @Override
    public String convert(GrantedAuthority source) {
        return source.getAuthority();
    }
}
