package com.fusemachine.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = LoggerFactory
			.getLogger(BaseTest.class);
	
	@BeforeClass
	public void setup(){
		try {
			//springTestContextPrepareTestInstance();
			logger.info("===== base test before class ===");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
