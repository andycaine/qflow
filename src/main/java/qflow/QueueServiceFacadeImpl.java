package qflow;

public class QueueServiceFacadeImpl implements QueueServiceFacade {

    private final QueueService queueService;

    public QueueServiceFacadeImpl(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void createQueue(QueueDTO queue) {
        queueService.storeQueue(fromDTO(queue));
    }

    private Queue fromDTO(QueueDTO dto) {
        return new Queue(dto.getName());
    }
}
