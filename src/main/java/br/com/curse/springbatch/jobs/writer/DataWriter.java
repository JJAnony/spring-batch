package br.com.curse.springbatch.jobs.writer;

import br.com.curse.springbatch.model.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataWriter {

    @Bean
    public ItemWriter dataItemWriter() {
        return item -> item.forEach(System.out::println);
    }
}
