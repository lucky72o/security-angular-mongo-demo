package com.example.securityangular.models.serializers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


@Component
public class StringToGrantedAuthorityConverter implements Converter<String, GrantedAuthority> {

    @Override
    public GrantedAuthority convert(String source) {
        return new SimpleGrantedAuthority(source);
    }
}
