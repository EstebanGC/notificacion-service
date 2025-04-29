package com.notificacion.service.service;

import com.notificacion.service.entity.NotificationRequest;
import com.notificacion.service.entity.NotificationResponse;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class NotificationService {

    private JavaMailSender emailSender;

    public NotificationResponse sendEmail(NotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();

        try {
            message.setTo(request.getRecipient());
            message.setSubject(request.getSubject());
            message.setText(request.getContent());

            emailSender.send(message);

            return NotificationResponse.builder()
                    .notificationId(UUID.randomUUID().toString())
                    .status("SENT")
                    .sentAt(LocalDateTime.now())
                    .build();
        } catch(Exception e) {
            return NotificationResponse.builder()
                    .status("FAILED")
                    .build();
        }
    }
}
