package br.com.curse.springbatch.jobs.reader;

import br.com.curse.springbatch.model.Client;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataReader {

    @Value("classpath:database.txt")
    public Resource dataFile;

    @Autowired
    public LineMapper datalineMapper;

    @Bean
    public FlatFileItemReader dataItemReader() throws IOException {
        return new FlatFileItemReaderBuilder()
                .name("data-item-reader")
                .resource(dataFile)
                .lineMapper(datalineMapper)
                .build();
    }


}
