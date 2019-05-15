package com.train4game.munoon;

import com.train4game.munoon.domain.Part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainPageHelper {
    public static Map<String, Object> mainPage(Map<String, Object> model, Iterable<Part> parts, Iterable<Part> allParts) {
        List<Integer> list = new ArrayList<>();

        allParts.forEach(part -> {
            if (part.isNeed())
                list.add(part.getCount());
        });

        if (list.size() == 0)
            model.put("computers", 0);
        else
            model.put("computers", Collections.min(list));

        model.put("parts", parts);
        return model;
    }
}
