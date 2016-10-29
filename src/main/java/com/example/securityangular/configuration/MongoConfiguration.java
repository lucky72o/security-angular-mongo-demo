package com.example.securityangular.configuration;

import com.example.securityangular.models.serializers.GrantedAuthorityToStringConverter;
import com.example.securityangular.models.serializers.StringToGrantedAuthorityConverter;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.securityangular.repositories")
public class MongoConfiguration extends AbstractMongoConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Override
    protected String getDatabaseName() {
        return "testsecurity";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    public CustomConversions customConversions() {
        converters.add(new GrantedAuthorityToStringConverter());
        converters.add(new StringToGrantedAuthorityConverter());
        return new CustomConversions(converters);
    }
}
