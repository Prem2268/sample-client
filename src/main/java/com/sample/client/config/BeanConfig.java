package com.sample.client.config;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
	
	@Value("${server.ssl.key-store}")
	private String keyStore;

	@Value("${server.ssl.key-store-password}")
	private String keyStorePWD;

	@Value("${server.ssl.trust-store}")
	private String trustStore;

	@Value("${server.ssl.trust-store-password}")
	private String trustStorePWD;

	@Bean
	public RestTemplate getRestTemplste() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {

		SSLContext sslContext = SSLContextBuilder.create()
				.loadKeyMaterial(new File(keyStore), keyStorePWD.toCharArray(), keyStorePWD.toCharArray())
				.loadTrustMaterial(new File(trustStore), trustStorePWD.toCharArray())
				.build();
		HttpClient httpClinet = HttpClients.custom()
				.setSSLContext(sslContext)
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.build();
		HttpComponentsClientHttpRequestFactory  factory= new HttpComponentsClientHttpRequestFactory(httpClinet);

		return new RestTemplate(factory);
	}


}
