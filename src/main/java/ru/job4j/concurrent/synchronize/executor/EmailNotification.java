package ru.job4j.concurrent.synchronize.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        String email = user.getEmail();
        String subject = String.format("Notification %s to email %s",
                user.getUsername(), email);
        String body = String.format("Add a new event to %s", email);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                send(subject, body, email);
            }
        });
    }

    private void send(String subject, String body, String email) {
    }

    public void close() {
        pool.shutdown();
    }

}
