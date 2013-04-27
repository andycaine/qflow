package qflow;

import java.util.Collection;

public interface QueueRepository {

    void store(Queue queue);

    Collection<Queue> findAll();
}
