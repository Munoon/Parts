package com.train4game.munoon;

import com.train4game.munoon.domain.Part;
import com.train4game.munoon.repos.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PartRepo partRepo;

    @GetMapping
    public String mainGetPage(
            Map<String, Object> model
    ) {
        Iterable<Part> parts = partRepo.findAll();
        model.put("parts", parts);
        return "index";
    }

    @PostMapping
    public String mainPostPage(
            @RequestParam String name,
            @RequestParam boolean need,
            @RequestParam int count,
            Map<String, Object> model
    ) {
        Part part = new Part(name, need, count);
        partRepo.save(part);

        return mainGetPage(model);
    }

    @PostMapping("/delete")
    public String deleteGetPage(
            @RequestParam(name = "id", required = true) Long id,
            Map<String, Object> model
    ) {
        partRepo.deleteById(id);
        return "redirect:/";
    }
}
