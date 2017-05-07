package com.Fun.Notification;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification,Integer>{

	public List<Notification> findBySId(String id);
}
