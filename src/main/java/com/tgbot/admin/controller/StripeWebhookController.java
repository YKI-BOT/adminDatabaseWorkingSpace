package com.tgbot.admin.controller;

import com.google.gson.JsonSyntaxException;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.billingportal.Session;
import com.stripe.net.Webhook;
import com.tgbot.admin.database.entity.BotUsersEntity;
import com.tgbot.admin.database.interfaces.BotUsersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/webhook/stripe")
public class StripeWebhookController {

    BotUsersRepository botUsersRepository;

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    @PostMapping
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws StripeException {
        Event event;

        try {
            event = Webhook.constructEvent(payload, sigHeader, webhookSecret);
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(400).body("Invalid signature");
        } catch (JsonSyntaxException e) {
            return ResponseEntity.status(400).body("Invalid payload");
        }

        if ("checkout.session.completed".equals(event.getType())) {
            EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
            Session session = (Session) dataObjectDeserializer.getObject().orElse(null);

            if (session != null) {
                String customerId = session.getCustomer();

                Customer customer = Customer.retrieve(customerId);
                Map<String, String> metadata = customer.getMetadata();
                Long chatId = Long.valueOf(metadata.get("chatId"));

                activateSubscription(chatId, 30L);
            }
        }
        return ResponseEntity.ok("Webhook handled successfully");
    }

    public void activateSubscription(Long chatId, Long durationInDays) {
        BotUsersEntity user = botUsersRepository.findByChatId(chatId);
        if (user != null) {
            user.setSubscriptionTime(LocalDate.now().plusDays(durationInDays));
            user.setSubscribed(true);
            botUsersRepository.save(user);
        }
    }
}