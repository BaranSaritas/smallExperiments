package com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.config;
// IntegrationConfig.java


import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel studentChannel() {

        return new PublishSubscribeChannel();
        //return new DirectChannel();
        /*
        DirectChannel: Spring Integration'da doğrudan iletim kanalıdır. Mesajlar, abonelere doğrudan iletilir. Bu kanal tek bir alıcıya sahiptir.
        ayni anda birden fazla dinleyen abone oldugunda veri kaciriyor eksik veri getiriyor test sonucu assagida
         */
    }

    @Bean
    public MessageSource<Student> studentSource() {
        return () -> new GenericMessage<>(new Student());
    }

    /*
    @ServiceActivator(inputChannel = "studentChannel"): Bu anotasyon, metodun bir hizmet aktivatörü olduğunu
     ve studentChannel adlı kanaldan gelen mesajları işleyeceğini belirtir.
     */
    @ServiceActivator(inputChannel = "studentChannel")
    public void handleMessage(Message<Student> message) {
        // data buraya gelicek service yazildiktan sorna
        System.out.println("Message received: " + message.getPayload());
    }
}


/*

-> DirectChannel oldugunda 2 service var dinleyen 1 tanesi cevap verebiliyor
Öğrenci eklendi: Student{id=0, name='Student', age=0}
Message received: Student{id=0, name='Student', age=0}
Öğrenci eklendi: Student{id=1, name='Student', age=1}
Yeni öğrenci eklendi: Student{id=1, name='Student', age=1}
Öğrenci eklendi: Student{id=2, name='Student', age=2}
Message received: Student{id=2, name='Student', age=2}
Öğrenci eklendi: Student{id=3, name='Student', age=3}
Yeni öğrenci eklendi: Student{id=3, name='Student', age=3}
Öğrenci eklendi: Student{id=4, name='Student', age=4}
Message received: Student{id=4, name='Student', age=4}

 */

/*
-> PublishSubscribeChannel birden fazla dinleyen oldugunda kullanilmali bu sayede hepsi cevap verebiliyor
Öğrenci eklendi: Student{id=0, name='Student', age=0}
Message received: Student{id=0, name='Student', age=0}
Yeni öğrenci eklendi: Student{id=0, name='Student', age=0}
Öğrenci eklendi: Student{id=1, name='Student', age=1}
Message received: Student{id=1, name='Student', age=1}
Yeni öğrenci eklendi: Student{id=1, name='Student', age=1}
Öğrenci eklendi: Student{id=2, name='Student', age=2}
Message received: Student{id=2, name='Student', age=2}
Yeni öğrenci eklendi: Student{id=2, name='Student', age=2}
Öğrenci eklendi: Student{id=3, name='Student', age=3}
Message received: Student{id=3, name='Student', age=3}
Yeni öğrenci eklendi: Student{id=3, name='Student', age=3}
Öğrenci eklendi: Student{id=4, name='Student', age=4}
Message received: Student{id=4, name='Student', age=4}
Yeni öğrenci eklendi: Student{id=4, name='Student', age=4}

 */