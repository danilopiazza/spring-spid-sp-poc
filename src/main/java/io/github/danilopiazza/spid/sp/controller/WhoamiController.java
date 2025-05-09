package io.github.danilopiazza.spid.sp.controller;

import io.github.danilopiazza.spid.sp.model.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/whoami")
public class WhoamiController {
    @GetMapping
    public UserInfo whoami(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
        return new UserInfo(principal.getName(), principal.getRelyingPartyRegistrationId(), getFirstAttributes(principal));
    }

    private Map<String, String> getFirstAttributes(Saml2AuthenticatedPrincipal principal) {
        return principal.getAttributes().keySet().stream().collect(Collectors.toMap(Function.identity(), principal::getFirstAttribute));
    }
}
