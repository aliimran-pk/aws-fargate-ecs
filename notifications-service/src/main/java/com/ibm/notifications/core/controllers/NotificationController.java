package com.ibm.notifications.core.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.notifications.core.dtos.EmailMessage;
import com.ibm.notifications.core.services.NotificationService;

@RestController
public class NotificationController {

	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/notification/send")
	public void sendNotification(@RequestBody EmailMessage message){
		logger.info("sendNotification Logger");
		System.out.println("sendNotification System Out");
		notificationService.sendEmail(message);
	}
	
	@GetMapping("/notification/health-status")
	public String healthStatus(){
		return "Notification Service v2 is Up and Running";
	}
	
	@GetMapping("/notification/info")
	public String notificationStatic(){
		String ip = null;
		String hostname = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String finalresult =   "Notification Service v2 IP Address: " + ip + "\n" + "Hostname: " + hostname;
		return finalresult;
	}
}
