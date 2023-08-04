package com.example.feignclient;

import com.example.feignclient.accessor.RestAPIAccessor;
import com.example.feignclient.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignclientApplication implements CommandLineRunner {

	private Logger LOG= LoggerFactory.getLogger(FeignclientApplication.class);
	private RestAPIAccessor restAPIAccessor;

	@Autowired
	public void setRestAPIAccessor(RestAPIAccessor restAPIAccessor){
		this.restAPIAccessor=restAPIAccessor;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product productFromFeignClient = restAPIAccessor.getProductFromRestAPI("4028b88189bf22430189bf2261a60000");
		LOG.info("Product from RESTAPIAPPLICATION:"+productFromFeignClient.toString());
	}
}
