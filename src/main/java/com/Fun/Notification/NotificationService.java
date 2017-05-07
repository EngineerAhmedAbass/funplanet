package com.Fun.Notification;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	public List<Notification> GetAllNotifications(String email) {
		List<Notification> notification=new ArrayList<>();
		notificationRepository.findBySId(email).forEach(notification::add);
		return notification;
	}

	public void addNotification(Notification notification) {
		notificationRepository.save(notification);
	}
	

}
