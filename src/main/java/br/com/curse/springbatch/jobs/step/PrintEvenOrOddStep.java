package br.com.curse.springbatch.jobs.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PrintEvenOrOddStep {

    @Autowired()
    private StepBuilderFactory stepFactory;

    @Bean
    public Step printEvenOrOdd() {
        return stepFactory.get("step-print-even-or-odd").<Integer, String>chunk(1).reader(contTen())
                .processor(evenOrOddProcessor()).writer(printResult()).build();
    }

    public IteratorItemReader<Integer> contTen() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numbers.iterator());
    }

    public FunctionItemProcessor<Integer, String> evenOrOddProcessor() {
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
    }


    public ItemWriter<String> printResult() {
        return itens -> itens.forEach(System.out::println);
    }
}
