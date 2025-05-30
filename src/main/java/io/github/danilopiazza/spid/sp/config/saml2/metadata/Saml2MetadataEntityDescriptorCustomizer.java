package io.github.danilopiazza.spid.sp.config.saml2.metadata;

import org.opensaml.saml.saml2.metadata.*;
import org.opensaml.saml.saml2.metadata.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Saml2MetadataEntityDescriptorCustomizer {
    @Value("${saml2.metadata.entity-descriptor.organization.name}")
    String organizationName;
    @Value("${saml2.metadata.entity-descriptor.organization.display-name}")
    String organizationDisplayName;
    @Value("${saml2.metadata.entity-descriptor.organization.url}")
    String organizationUrl;

    public void customize(EntityDescriptor entityDescriptor) {
        entityDescriptor.setOrganization(organization());
        entityDescriptor.getContactPersons().add(contactPerson());
    }

    private Organization organization() {
        Organization organization = new OrganizationBuilder().buildObject();

        OrganizationName name = new OrganizationNameBuilder().buildObject();
        name.setValue(organizationName);
        organization.getOrganizationNames().add(name);

        OrganizationDisplayName displayName = new OrganizationDisplayNameBuilder().buildObject();
        displayName.setValue(organizationDisplayName);
        organization.getDisplayNames().add(displayName);

        OrganizationURL url = new OrganizationURLBuilder().buildObject();
        url.setURI(organizationUrl);
        organization.getURLs().add(url);

        return organization;
    }

    private ContactPerson contactPerson() {
        ContactPerson contactPerson = new ContactPersonBuilder().buildObject();

        contactPerson.setType(ContactPersonTypeEnumeration.OTHER);

        return contactPerson;
    }
}
