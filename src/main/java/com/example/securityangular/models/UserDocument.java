package com.example.securityangular.models;

import com.example.securityangular.models.serializers.StringToGrantedAuthorityConverter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Convert;
import java.util.List;

@Document(collection = "users")
public class UserDocument {

    @Id
    public String id;

    private String name;
    private String password;

    private List<GrantedAuthority> roles;

    public UserDocument(String name, String password, List<GrantedAuthority> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserDocument() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("password", password)
                .append("roles", roles)
                .toString();
    }
}
