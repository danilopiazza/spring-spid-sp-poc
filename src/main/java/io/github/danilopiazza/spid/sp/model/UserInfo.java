package io.github.danilopiazza.spid.sp.model;

import java.util.Map;

public record UserInfo(String name, String registrationId, Map<String, String> attributes) {
}
