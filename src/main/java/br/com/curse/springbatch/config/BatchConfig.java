package br.com.curse.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired()
    private JobBuilderFactory factory;
    @Bean
    public Job clientFileJob(Step clientFileStep) {
        return factory.get("client-job")
                .start(clientFileStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
