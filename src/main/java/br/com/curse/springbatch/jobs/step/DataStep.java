package br.com.curse.springbatch.jobs.step;


import br.com.curse.springbatch.model.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataStep {

    @Autowired
    private StepBuilderFactory stepFactory;

    @Bean
    public Step clientFileStep(ItemReader dataItemReader, ItemWriter dataItemWriter) {
        return stepFactory.get("data-file-step")
                .<Client, Client>chunk(1)
                .reader(dataItemReader)
                .writer(dataItemWriter)
                .build();
    }
}
