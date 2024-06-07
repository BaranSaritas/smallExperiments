package com.smallExperiments.smallExperiments.SpringBasicMessageIntegration;

import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.model.Student;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @ServiceActivator(inputChannel = "studentChannel")
    public void sendNotification(Message<Student> message) {
        Student student = message.getPayload();
        //Spring Integration mesajının içeriğini (payload) alarak bir Student nesnesine dönüştürür
        System.out.println("Yeni öğrenci eklendi: " + student);

    }
}