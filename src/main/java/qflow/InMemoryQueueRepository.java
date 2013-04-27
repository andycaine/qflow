package qflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryQueueRepository implements QueueRepository {

    private long nextId = 1;

    private Map<Long, Queue> queues = new HashMap<Long, Queue>();

    @Override
    public void store(Queue queue) {
        queue.setId(nextId++);
        queues.put(queue.getId(), queue);
    }

    @Override
    public Collection<Queue> findAll() {
        return queues.values();
    }
}
