package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ApplicationContextUtil {
     private  static ApplicationContext ac=null;
     static{ac=new ClassPathXmlApplicationContext("applicationContext.xml");}
    
     public static  ApplicationContext getApplicationContext(){
    	 return ac;
     }
//     public static void main(String[] args) {
//		System.out.println(ac.toString());
//	}
}
