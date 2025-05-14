package io.github.danilopiazza.spid.sp.config.saml2;

import io.github.danilopiazza.spid.sp.config.saml2.metadata.Saml2MetadataEntityDescriptorMarshaller;
import org.opensaml.saml.saml2.metadata.EntityDescriptor;
import org.springframework.security.saml2.core.OpenSamlInitializationService;

public class Saml2Initializer {
    public static void initialize() {
        OpenSamlInitializationService.requireInitialize(factory -> factory.getMarshallerFactory().registerMarshaller(EntityDescriptor.DEFAULT_ELEMENT_NAME, new Saml2MetadataEntityDescriptorMarshaller()));
    }
}
