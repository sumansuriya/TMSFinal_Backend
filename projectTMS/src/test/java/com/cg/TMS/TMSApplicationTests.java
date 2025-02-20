package com.cg.TMS;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Leave;
import com.cg.TMS.entity.Task;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.services.AdminLeaveApprovalService;
import com.cg.TMS.services.AdminTaskService;
import com.cg.TMS.services.IAdminLeaveApprovalService;

@SpringBootTest
class TMSApplicationTests {

	@Test
	void contextLoads() {
	}
	

	
  			
	@Test
	public void testdeadLine1() throws Exception {

		Task test1 = new Task();
		    test1.setStartDate(Calendar.getInstance());
		    
	   Calendar calc = Calendar.getInstance();
             test1.setDeadLineAuto(calc);
        

        boolean result = test1.getDeadLine().after(test1.getStartDate());
	    assertTrue(result);

	  }

	
   @Test
   public void testdeadLine2() throws Exception {

		Task test2 = new Task();
		    test2.setStartDate(Calendar.getInstance());
		    
	   Calendar calc = Calendar.getInstance();
            test2.setDeadLineAuto(calc);
       

       boolean result = test2.getDeadLine().before(test2.getStartDate());
	    assertFalse(result);
	    
	}
}
