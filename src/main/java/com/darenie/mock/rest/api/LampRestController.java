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

    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
    public String getStatus(@PathVariable(name = "id") Integer id) {
        return lampMap.get(id).getStatus();
    }

    @RequestMapping(value = "/{status}/{id}", method = RequestMethod.POST)
    public void setStatus(@PathVariable(name = "status") String status ,@PathVariable(name = "id") Integer id) {
        if (isStatusValid(status) && lampMap.get(id) != null) {
            lampMap.get(id).setStatus(status);
        } else {
            throw new IllegalArgumentException("Illegal status argument or lamp doesn't exist");
        }
    }

    @PostConstruct
    private void fillMap() {
        putToLampMap(1,LampData.Status.BROKEN);
        putToLampMap(2,LampData.Status.WORKING);
        putToLampMap(3,LampData.Status.WORKING);
        putToLampMap(4,LampData.Status.BROKEN);
        putToLampMap(5,LampData.Status.WORKING);
        putToLampMap(6,LampData.Status.NOT_WORKING);
    }

    private void putToLampMap(int lampId, String status) {
        lampMap.put(lampId, new LampData(lampId,status));
    }

    private boolean isStatusValid (String status) {
        return  status.equalsIgnoreCase(LampData.Status.BROKEN) ||
                status.equalsIgnoreCase(LampData.Status.NOT_WORKING) ||
                status.equalsIgnoreCase(LampData.Status.WORKING);
    }
}
