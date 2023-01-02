package com.mitrais.organisation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@SpringBootTest
@BootstrapWith(value = SpringBootTestContextBootstrapper.class)
class OrganisationApplicationTests {

	@Test
	void contextLoads() {
	}

}
