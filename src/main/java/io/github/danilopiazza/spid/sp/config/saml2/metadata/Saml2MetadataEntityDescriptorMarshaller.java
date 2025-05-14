package io.github.danilopiazza.spid.sp.config.saml2.metadata;

import io.github.danilopiazza.spid.sp.config.context.ApplicationContextProvider;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.saml.saml2.metadata.*;
import org.opensaml.saml.saml2.metadata.impl.*;
import org.w3c.dom.Element;

public class Saml2MetadataEntityDescriptorMarshaller extends EntityDescriptorMarshaller {
    private Saml2MetadataEntityDescriptorCustomizer entityDescriptorCustomizer;

    @Override
    protected void marshallChildElements(XMLObject samlElement, Element domElement) throws MarshallingException {
        Saml2MetadataEntityDescriptorCustomizer entityDescriptorCustomizer = ApplicationContextProvider.getContext().getBean(Saml2MetadataEntityDescriptorCustomizer.class);
        if (samlElement instanceof EntityDescriptor entityDescriptor) {
            entityDescriptorCustomizer.customize(entityDescriptor);
        }
        super.marshallChildElements(samlElement, domElement);
    }
}
