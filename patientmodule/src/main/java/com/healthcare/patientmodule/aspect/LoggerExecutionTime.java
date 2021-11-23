package com.healthcare.patientmodule.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerExecutionTime {

   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   @After("@annotation(com.healthcare.patientmodule.aspect.LogTimeAnnotation)")
   public void beforeAdvice(JoinPoint joinPoint){
	   System.out.println(joinPoint.getSignature().getName() +  " Execution Bgins");
	   long start = System.currentTimeMillis();

	    long executionTime = System.currentTimeMillis() - start;

		System.out.println(joinPoint.getSignature().getName() +  " executed in " + executionTime + "ms");
   }  
   
}