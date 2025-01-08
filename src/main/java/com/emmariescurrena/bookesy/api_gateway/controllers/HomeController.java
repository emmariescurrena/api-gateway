package com.emmariescurrena.bookesy.api_gateway.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    @GetMapping("/")
    public String howdy(@AuthenticationPrincipal OidcUser user) {
        return "Hello, " + user.getEmail();
    }

    @GetMapping("/print-token")
    public String printAccessToken(@RegisteredOAuth2AuthorizedClient("okta")
                                   OAuth2AuthorizedClient authorizedClient) {

        return authorizedClient.getAccessToken().getTokenValue();

    }
}
