package qflow;

public class QueueServiceImpl implements QueueService {

    private final QueueRepository queueRepository;

    public QueueServiceImpl(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public void storeQueue(Queue queue) {
        queueRepository.store(queue);
    }
}
