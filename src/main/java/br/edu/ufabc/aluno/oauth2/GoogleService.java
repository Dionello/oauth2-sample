package br.edu.ufabc.aluno.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google")
public class GoogleService {
    @Autowired
    OAuth2AuthorizedClientService authorizedClientService;
    @GetMapping
    public Object info(OAuth2AuthenticationToken token){

        return token.getPrincipal().getAttributes();
    }

    @GetMapping("token")
    public Object accessToken(OAuth2AuthenticationToken token){
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
        return client.getAccessToken();
    }
}

