package com.smallExperiments.smallExperiments.SpringBasicMessageIntegration;

import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.model.Student;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private MessageChannel studentChannel;

    public StudentService(MessageChannel studentChannel) {
        this.studentChannel = studentChannel;
    }

    public void addStudent(Student student) {
        // Öğrenci ekleme işlemi...
        System.out.println("Öğrenci eklendi: " + student);

        // Yeni öğrenci eklendiğinde mesajı gönder
        studentChannel.send(new GenericMessage<>(student));
    }
}
