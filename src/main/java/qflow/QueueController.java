package qflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/queues")
public class QueueController {

    public static final String NEW_VIEW = "queues/new";

    private final QueueRepository queueRepository;

    @Autowired
    public QueueController(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newQueue(Model model) {
        model.addAttribute("queue", new Queue());
        return NEW_VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createQueue(@ModelAttribute Queue queue, Errors errors) {
        if (errors.hasErrors()) {
            return NEW_VIEW;
        }
        queueRepository.store(queue);
        return "redirect:/queues";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listQueues(Model model) {
        model.addAttribute("queues", queueRepository.findAll());
        return "queues/list";
    }

}
