package com.example.campusoverflow.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendEmail(String to, String username, String subject, EmailTemplateName emailTemplate, String confirmationUrl, String activationCode) throws MessagingException {
        String TemplateName;
        if (emailTemplate == null){
            TemplateName = "activate-account";
        } else {
            TemplateName = emailTemplate.getName();
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                MULTIPART_MODE_MIXED,
                UTF_8.name()
        );
        Map<String, Object> propreties = new HashMap<>();
        propreties.put("username", username);
        propreties.put("confirmationUrl", confirmationUrl);
        propreties.put("activationCode", activationCode);

        Context context = new Context();
        context.setVariables(propreties);

        helper.setFrom("contact@campus-overflow.com");
        helper.setTo(to);
        helper.setSubject(subject);

        String tempalte = templateEngine.process(TemplateName, context);
        helper.setText(tempalte, true);
        mailSender.send(mimeMessage);

    }
}
