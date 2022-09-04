package com.example.failureanalyzer.analyzer;

import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class CustomBeanNotOfRequiredTypeFailureAnalyzer extends AbstractFailureAnalyzer<BeanNotOfRequiredTypeException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, BeanNotOfRequiredTypeException cause) {
        return new FailureAnalysis(getDescription(cause), getAction(cause), cause);
    }

    private String getDescription(BeanNotOfRequiredTypeException exception) {
        return String.format("%s bean'i, %s türünde olduğu için %s olarak enjekte edilemedi.",
                exception.getBeanName(),
                exception.getActualType().getName(),
                exception.getRequiredType().getName());
    }

    private String getAction(BeanNotOfRequiredTypeException exception) {
        return String.format("%s türünde %s adında bir bean oluşturmayı düşünün.",
                exception.getRequiredType().getName(),
                exception.getBeanName());
    }
}
