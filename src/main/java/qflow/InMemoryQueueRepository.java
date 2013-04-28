package qflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class InMemoryQueueRepository implements QueueRepository {

    private long nextId = 1;

    private Map<Long, Queue> queues = new HashMap<Long, Queue>();

    @Override
    public void save(Queue queue) {
        if (queue.isNew()) {
            queue.setId(nextId++);
            queues.put(queue.getId(), queue);
        }
        for (Item item : queue.getItems()) {
            if (item.isNew()) {
                item.setId(nextId++);
            }
        }
    }

    @Override
    public Collection<Queue> findAll() {
        return queues.values();
    }

    @Override
    public Queue find(long queueId) {
        if (!exists(queueId)) throw new NoSuchElementException("No queue with id " + queueId);
        return queues.get(queueId);
    }

    private boolean exists(long queueId) {
        return queues.containsKey(queueId);
    }
}
