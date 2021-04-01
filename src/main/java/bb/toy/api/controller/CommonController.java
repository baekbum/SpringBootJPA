package bb.toy.api.controller;

import bb.toy.api.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class CommonController {

    private final CommonService commonService;

    @GetMapping("/api/common/userProperties")
    public Map<String, Object> getUserProperties() {
        Map<String, Object> map = new HashMap<>();

        map.put("rank", commonService.getRanks());
        map.put("position", commonService.getPositions());
        map.put("team", commonService.getTeams());

        return map;
    }
}
