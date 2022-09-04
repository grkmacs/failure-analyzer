package com.example.failureanalyzer.service;

import com.example.failureanalyzer.dao.FirstDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExampleService {
    @Resource
    private FirstDao firstDao;
}
