package qflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/queues/{queueId}/items")
public class ItemController {

    private final QueueRepository queueRepository;

    @Autowired
    public ItemController(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listItems(@PathVariable Long queueId, Model model) {
        Queue queue = queueRepository.find(queueId);
        model.addAttribute("queue", queue);
        return "queues/items/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "queues/items/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createItem(@PathVariable Long queueId, @ModelAttribute Item item) {
        Queue queue = queueRepository.find(queueId);
        queue.addItem(item);
        queueRepository.save(queue);
        return "redirect:/queues/" + queueId + "/items";
    }
}
