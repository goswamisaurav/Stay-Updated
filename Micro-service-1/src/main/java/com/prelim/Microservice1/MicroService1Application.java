package com.prelim.Microservice1;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class MicroService1Application {

	public static void main(String[] args) throws IOException, InterruptedException, JSONException {
		SpringApplication.run(MicroService1Application.class, args);
		SHR shr;
         //while( true) {
		shr = new SHR("https://www.hackerearth.com/challenges/");
		List<Competition> coms =  shr.Scrap();
		SendBatchData.sendBatchData(coms);
		//System.out.println(coms);
		System.out.println(SendBatchData.getJSONString(coms));
		  //Thread.sleep(23*60*60*1000);
	  //}

	}

}
