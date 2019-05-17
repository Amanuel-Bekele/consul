package com.example.demoConsul;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoConsulApplication.class)
public class DemoConsulApplicationTests {

	@Autowired
	DiscoveryClient client;

	@Test
	public void testServiceIsRegisteredWithConsul() {
		List<ServiceInstance> allInstances = client.getInstances("consulDemo-instance");
		Assert.assertEquals(1, allInstances.size());


	}

}
