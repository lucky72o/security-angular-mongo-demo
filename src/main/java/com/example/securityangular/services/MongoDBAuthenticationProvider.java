package com.example.securityangular.services;

import com.example.securityangular.models.UserDocument;
import com.example.securityangular.repositories.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserDocumentRepository userDocumentRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        Optional<UserDocument> userOptional = userDocumentRepository.findByName(username);

        if (userOptional.isPresent()) {
            UserDocument userDocument = userOptional.get();
            return new User(userDocument.getName(), userDocument.getPassword(), userDocument.getRoles());
        } else {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
    }
}