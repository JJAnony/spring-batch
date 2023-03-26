package br.com.curse.springbatch.jobs.reader;

import br.com.curse.springbatch.model.Client;
import br.com.curse.springbatch.model.Transaction;
import org.springframework.batch.item.*;

public class ClientReader implements ItemStreamReader<Client> {

    private Object current;
    private ItemStreamReader<Object> itemStreamReader;

    public ClientReader(ItemStreamReader<Object> itemStreamReader) {
        this.itemStreamReader = itemStreamReader;
    }

    @Override
    public Client read() throws Exception {
        if (current == null)
           current = itemStreamReader.read();

        Client client = (Client) current;

        if (client != null) {
            while (peek() instanceof Transaction) {
                client.transactions.add((Transaction) current);
            }
        }

        return client;
    }

    private Object peek() throws Exception {
        current = itemStreamReader.read();
        return current;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        itemStreamReader.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        itemStreamReader.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        itemStreamReader.close();
    }
}
