package com.nexus.stickman.net;

/** Configure only a backend you own. Do not assume the legacy publisher endpoint is active. */
public final class OnlineConfig {
    private OnlineConfig() {}
    public static final String BASE_URL = ""; // e.g. https://your-project.example/api
    public static boolean isConfigured() { return BASE_URL != null && !BASE_URL.trim().isEmpty(); }
}
