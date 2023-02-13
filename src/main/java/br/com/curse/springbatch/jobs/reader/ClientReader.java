package br.com.curse.springbatch.jobs.reader;

import br.com.curse.springbatch.model.Client;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ClientReader {

    @Value("classpath:client.txt")
    public Resource clientFile;

    @Bean
    public FlatFileItemReader<Client> clientItemReader() throws IOException {
        System.out.println("File Log: " + clientFile.getURI());
        return new FlatFileItemReaderBuilder<Client>()
                .name("client-item-reader")
                .resource(clientFile)
                .delimited()
                .names(new String[]{"name", "lastName", "age", "email"})
                .targetType(Client.class)
                .build();
    }
}
