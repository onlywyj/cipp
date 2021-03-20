package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtCertificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtCertificationController {
    @Resource
    private HtCertificationService htCertificationService;

    @GetMapping("/htgetCertification")
    public Map getCertification(@RequestParam("session") String session){
        Map map = htCertificationService.getCertification(session);
        return map;
    }

    @GetMapping("/htCertification")
    public Map certification(@RequestParam("session") String session,
                             @RequestParam("id") String id,
                             @RequestParam("agree") String agree){
        Map map = htCertificationService.certification(session,id,agree);
        return  map;
    }
}
