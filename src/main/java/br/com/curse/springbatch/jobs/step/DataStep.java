package br.com.curse.springbatch.jobs.step;


import br.com.curse.springbatch.jobs.reader.ClientReader;
import br.com.curse.springbatch.model.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataStep {

    @Autowired
    private StepBuilderFactory stepFactory;

    @Bean
    public Step clientFileStep(FlatFileItemReader dataItemReader, ItemWriter dataItemWriter) {
        return stepFactory.get("data-file-step")
                .<Client, Client>chunk(1)
                .reader(new ClientReader(dataItemReader))
                .writer(dataItemWriter)
                .build();
    }
}
