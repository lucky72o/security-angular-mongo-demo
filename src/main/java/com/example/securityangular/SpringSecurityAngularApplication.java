package com.example.securityangular;

import com.example.securityangular.models.serializers.GrantedAuthorityToStringConverter;
import com.example.securityangular.models.serializers.StringToGrantedAuthorityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringSecurityAngularApplication {

	@Bean
	public GenericConversionService defaultConversionService() {
		return new GenericConversionService();
	}

	@Bean
	public StringToGrantedAuthorityConverter stringToGrantedAuthorityConverter(){
		StringToGrantedAuthorityConverter converter = new StringToGrantedAuthorityConverter();
		defaultConversionService().addConverter(converter);
		return converter;
	}

	@Bean
	public GrantedAuthorityToStringConverter grantedAuthorityConverterToString(){
		GrantedAuthorityToStringConverter converter = new GrantedAuthorityToStringConverter();
		defaultConversionService().addConverter(converter);
		return converter;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAngularApplication.class, args);
	}
}
