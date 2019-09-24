package com.topica.edu.itlab.springcsv;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        //Get the Spring Context
  		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
  		
  		//Get the PersionDAO Bean
  		PersionDAO persionDAO = ctx.getBean("persionDAO", PersionDAO.class);
  		Persion persion = ctx.getBean("persion", Persion.class);
  		
  		FileInputStream input = null;
  		Scanner scanner = null;
  		try {
			input = new FileInputStream("persion.csv");
			scanner = new Scanner(input);
			scanner.nextLine();
			while (scanner.hasNext()) {
				persion.setPersion(scanner.nextLine());
				persionDAO.save(persion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
  		finally {
  			scanner.close();
  			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
  			ctx.close();
		}
    }
}
