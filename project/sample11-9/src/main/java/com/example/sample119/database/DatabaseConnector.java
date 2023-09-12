package com.example.sample119.database;

// import org.springframework.beans.factory.annotation.Value;

public abstract class DatabaseConnector {
    // @Value("${default.url}")
    private String url;
    /**
     * Hàm này có nhiệm vụ Connect tới một Database bất kỳ
     */
    public abstract void connect();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
