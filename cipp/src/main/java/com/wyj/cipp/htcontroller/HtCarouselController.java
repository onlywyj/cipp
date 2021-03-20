package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtCarouselService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtCarouselController {

    @Resource
    private HtCarouselService htCarouselService;

    @GetMapping("/htgetCarousel")
    public Map getCarousel(@RequestParam("session") String session){
        Map map = htCarouselService.getCarousel(session);
        return map;
    }

    @GetMapping("/htdelCarousel")
    public Map delCarousel(@RequestParam("session") String session,
                           @RequestParam("id") String id){
        Map map = htCarouselService.delCarousel(session,id);
        return  map;
    }

    @GetMapping("/htaddCarousel")
    public Map addCarousel(@RequestParam("imgUrl") String img,
                           @RequestParam("judUrl") String judUrl,
                           @RequestParam("session") String session){
        Map map = htCarouselService.addCarousel(img,judUrl,session);
        return map;
    }

}
