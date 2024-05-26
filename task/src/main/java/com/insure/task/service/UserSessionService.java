package com.insure.task.service;

import org.springframework.stereotype.Service;

@Service
public class UserSessionService {
    private static boolean loggedIn = false;
    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void login(String id) {
        userId = id;
        loggedIn = true;
    }

    public static void logout() {
        userId = null;
        loggedIn = false;
    }

    public static boolean getLoggedStatus() {
        return loggedIn;
    }
}
