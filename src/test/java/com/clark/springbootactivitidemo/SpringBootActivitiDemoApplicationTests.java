package com.clark.springbootactivitidemo;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.logging.Log;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootActivitiDemoApplicationTests {

	@Autowired
	private ProcessEngine processEngine;
	@Autowired
    private IdentityService identityService;
	@Autowired
    private TaskService taskService;
	@Autowired
    private RuntimeService runtimeService;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBootActivitiDemoApplicationTests.class.getName());
	@Test
	public void contextLoads() {
        Assert.assertEquals(1,processEngine.getRepositoryService().createDeploymentQuery().list().size());
		Assert.assertNotNull(processEngine.getRepositoryService().createProcessDefinitionQuery().list());
	}
	@Test
    public void testVocation(){
	    //Start a process
        Map<String,Object> variable = new HashMap<String, Object>();
        variable.put("employeeName","Clark");
        variable.put("numberOfDays",7);
        variable.put("vacationMotivation","I want to have some rest");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest",variable);
        Assert.assertNotNull(processInstance);
        logger.warn(processInstance.toString());
        //Fetch all tasks for manager group and complete them all
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        Map<String, Object> taskVariable = new HashMap<String, Object>();
        taskVariable.put("vacationApproved",false);
        taskVariable.put("managerMotivation","Have a nice holiday!");
        for(Task task : tasks){
            System.out.println(new JSONObject(task).toString());
            taskService.complete(task.getId(),taskVariable);
        }
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("Clark").list();
        System.out.println(tasks.size());
        variable.put("numberOfDays",3);
        variable.put("resendRequest",false);
        for(Task task : tasks){
            System.out.println(new JSONObject(task).toString());
            taskService.complete(task.getId(),variable);
        }
    }
}
