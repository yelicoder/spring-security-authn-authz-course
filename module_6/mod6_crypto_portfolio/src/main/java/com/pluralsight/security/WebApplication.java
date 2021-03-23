package com.pluralsight.security;

import com.pluralsight.security.entity.CryptoUser;
import com.pluralsight.security.entity.Portfolio;
import com.pluralsight.security.event.UserRegistrationEvent;
import com.pluralsight.security.repository.PortfolioRepository;
import com.pluralsight.security.repository.UserRepository;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.pluralsight.security.entity.CryptoCurrency;
import com.pluralsight.security.repository.CryptoCurrencyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@RequiredArgsConstructor
public class WebApplication {

	private final CryptoCurrencyRepository cryptoRepository;


    PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
    UserRepository repository;

	@Autowired
    PortfolioRepository portfolioRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void intializeUserData() {		
		CryptoCurrency bitcoin = new CryptoCurrency("BTC", "Bitcoin");
		CryptoCurrency litecoin = new CryptoCurrency("LTC", "Litecoin");
		cryptoRepository.save(bitcoin);
		cryptoRepository.save(litecoin);

		//by pass registration
        CryptoUser cryptUser = new CryptoUser(
                "test",
                "test",
                "test",
                "test@gmail.com",
                encoder.encode("0322$Plural"),
                encoder.encode("322"),
                false
        );
        cryptUser.setVerified(true);
        repository.save(cryptUser);
        portfolioRepository.save(new Portfolio("test", new ArrayList<>()));
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(redirectConnector());
        return tomcat;
    }

    private Connector redirectConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setRedirectPort(8443);
        return connector;
    }
	
}