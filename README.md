# SPID SAML 2.0 Service Provider

Itlaian SPID SAML 2.0 Service Provider proof-of-concept based on [Spring Boot 3](https://spring.io/projects/spring-boot)
and [Spring Security SAML 2](https://docs.spring.io/spring-security/reference/servlet/saml2/index.html).

## Getting Started

### External Services

Start any required external services with [Docker Compose](https://docs.docker.com/compose/):

    docker compose up

### Running

Build and run the project:

    mvn spring-boot:run

### SPID Identity Provider Setup

Set up your [SPID Demo Identity Provider](https://github.com/italia/spid-saml-check):

1. Open https://localhost:8443/ in your web browser
2. Log in with the following credentials:
    - Username: **validator**
    - Password: **validator**
3. Upload your Service Provider metadata **using the IP address of either your
   LAN network interface or your Docker virtual newtork. Do not use either
   localhost nor 127.0.0.1.**. For example, if your IP address is 172.26.240.1,
   submit the following metadata URL: http://172.26.240.1:8080/saml2/metadata.
4. **TODO**: This currently won't work, because the SP metadata is missing the
   `Organization` element.

See also: [How to use it as a SPID Demo](https://github.com/italia/spid-saml-check?tab=readme-ov-file#how-to-use-it-as-a-spid-demo).

### Login

Open http://localhost:8080/ in your web browser to start the SAML 2 login flow.

**TODO**: This currently won't work, because the SP has not been registered with
the IdP.
