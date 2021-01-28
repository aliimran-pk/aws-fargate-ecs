package com.ibm.notifications.core.services;

import com.ibm.notifications.core.dtos.EmailMessage;

public interface NotificationService {

	public void sendEmail(EmailMessage emailMessage);

}
