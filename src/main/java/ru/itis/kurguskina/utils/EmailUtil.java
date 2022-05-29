package ru.itis.kurguskina.utils;

import java.util.Map;

public interface EmailUtil {
    void sendMail(String to, String subject, String templateName, Map<String, String> data);
}
