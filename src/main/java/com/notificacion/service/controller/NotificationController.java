package com.notificacion.service.controller;

import com.notificacion.service.entity.NotificationRequest;
import com.notificacion.service.entity.NotificationResponse;
import com.notificacion.service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nofitications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/email")
    public ResponseEntity<NotificationResponse> sendEmail(@RequestBody NotificationRequest request) {
        return ResponseEntity.ok(notificationService.sendEmail(request));
    }
}
