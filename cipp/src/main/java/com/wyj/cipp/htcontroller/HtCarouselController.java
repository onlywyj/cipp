package com.wyj.cipp.htcontroller;

import com.wyj.cipp.dao.HtCarouselDao;
import com.wyj.cipp.model.CarouselModel;
import com.wyj.cipp.service.HtCarouselService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HtCarouselController {

    @Resource
    private HtCarouselService htCarouselService;
    @Resource
    private HtCarouselDao htCarouselDao;

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

    @GetMapping("/htCarouselList")
    public String toUserList(Model model){
        List<CarouselModel> listAll = htCarouselDao.getCarousel();
        model.addAttribute("list",listAll);
        return "admin/carousel_list";
    }

}
