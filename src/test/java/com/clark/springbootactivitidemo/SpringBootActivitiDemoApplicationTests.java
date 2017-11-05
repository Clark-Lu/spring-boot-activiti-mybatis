package com.clark.springbootactivitidemo;

import org.activiti.engine.ProcessEngine;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootActivitiDemoApplicationTests {

	@Autowired
	private ProcessEngine processEngine;
	@Test
	public void contextLoads() {
	    System.out.println(processEngine.getRepositoryService().createDeploymentQuery().list());
		System.out.println(processEngine.getRepositoryService().createProcessDefinitionQuery().list());
	}

}
