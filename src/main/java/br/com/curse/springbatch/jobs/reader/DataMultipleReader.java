package br.com.curse.springbatch.jobs.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DataMultipleReader {

    @Value("classpath:database*")
    public Resource[] dataFiles;

    @Bean
    public MultiResourceItemReader multiResourceItemReader(FlatFileItemReader flatFileItemReader){
        return new MultiResourceItemReaderBuilder()
                .name("multi-resource")
                .resources(dataFiles)
                .delegate(new ClientReader(flatFileItemReader))
                .build();

    }

}
