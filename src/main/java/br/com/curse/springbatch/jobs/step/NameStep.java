package br.com.curse.springbatch.jobs.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NameStep {

    @Autowired()
    private StepBuilderFactory stepFactory;

    @Bean
    public Step printStep(Tasklet nameTasklet) {
        return stepFactory.get("step-print-name").tasklet(nameTasklet).build();
    }

}
