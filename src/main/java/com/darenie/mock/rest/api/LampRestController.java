package com.darenie.mock.rest.api;

import com.darenie.mock.model.dto.LampData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/lamp")
public class LampRestController {

    private ConcurrentHashMap<Integer, LampData> lampMap = new ConcurrentHashMap();

    @RequestMapping(value = "/status/{id}", method = RequestMethod.POST)
    public String dare (@PathVariable(name = "id") Integer id) {
        return lampMap.get(id).getStatus();
    }

    @PostConstruct
    private void fillMap() {
        putToLampMap(1,LampData.Status.BROKEN);
        putToLampMap(2,LampData.Status.ON);
        putToLampMap(3,LampData.Status.ON);
        putToLampMap(4,LampData.Status.BROKEN);
        putToLampMap(5,LampData.Status.ON);
        putToLampMap(6,LampData.Status.OFF);
    }

    private void putToLampMap(int lampId, String status) {
        lampMap.put(lampId, new LampData(lampId,status));
    }
}
