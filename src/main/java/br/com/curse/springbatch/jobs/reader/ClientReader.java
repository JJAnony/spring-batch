package br.com.curse.springbatch.jobs.reader;

import br.com.curse.springbatch.model.Client;
import br.com.curse.springbatch.model.Transaction;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ClientReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client> {

    private Object current;
    private FlatFileItemReader<Object> delegate;

    public ClientReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Client read() throws Exception {
        if (current == null)
            current = delegate.read();

        Client client = (Client) current;

        if (client != null) {
            while (peek() instanceof Transaction) {
                client.transactions.add((Transaction) current);
            }
        }

        return client;
    }

    private Object peek() throws Exception {
        current = delegate.read();
        return current;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
