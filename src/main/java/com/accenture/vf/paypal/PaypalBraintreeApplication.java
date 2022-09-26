package com.accenture.vf.paypal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;

@SpringBootApplication
public class PaypalBraintreeApplication {

	// Below are the Braintree sandbox credentials
	private static BraintreeGateway gateway = null;
	private static String publicKey = "36n3jth7syn5sn38";
	private static String privateKey = "f8435b2a913f96a988b779765146c3df";
	private static String merchantId = "frxw99d5czj2fkty";
	private static String clientToken = null;

	public static void main(String[] args) {
		SpringApplication.run(PaypalBraintreeApplication.class, args);

		// Initialize Braintree Connection
		gateway = connectBraintreeGateway();

		// getclienttoken
		clientToken = generateClientToken();

	}

	// Connect to Braintree Gateway.
	public static BraintreeGateway connectBraintreeGateway() {
		BraintreeGateway braintreeGateway = new BraintreeGateway(Environment.SANDBOX, merchantId, publicKey,
				privateKey);
		return braintreeGateway;
	}

	private static String generateClientToken() {

		String clientToken = gateway.clientToken().generate();
		System.out.println("clientToken: "+clientToken);
		return clientToken;
	}

}
