package br.com.curse.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired()
    private JobBuilderFactory factory;

    @Bean
    public Job printStepJob(Step printStep) {
        return factory.get("print-job").start(printStep).build();
    }

    @Bean
    public Job printEvenOrOddJob(Step printEvenOrOdd) {
        return factory.get("print-even-or-odd-job").start(printEvenOrOdd).build();
    }
}
