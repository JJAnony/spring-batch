package br.com.curse.springbatch.jobs.writer;

import br.com.curse.springbatch.model.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientWriter {

    @Bean
    public ItemWriter<Client> clientItemWriter() {
        return item -> item.forEach(System.out::println);
    }
}
