package qflow;

import java.util.Collection;

public interface QueueRepository {

    void save(Queue queue);

    Collection<Queue> findAll();

    Queue find(long queueId);
}
