package com.example.failureanalyzer.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

public class CustomPortInUseFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException> {
    public CustomPortInUseFailureAnalyzer() {
    }

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis("Uygulama başlatılamadı çünkü " + cause.getPort() + " portunda çalışan başka bir uygulama var.", "Projenizin ayağa kaldırırken ki portunuzu application.properties dosyasından değiştirin veya diğer uygulamayı durdurun. ", cause);
    }
}
