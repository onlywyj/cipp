package com.wyj.cipp.htcontroller;

import com.wyj.cipp.dao.HtCertificationDao;
import com.wyj.cipp.model.CertificationModel;
import com.wyj.cipp.service.HtCertificationService;
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
public class HtCertificationController {
    @Resource
    private HtCertificationService htCertificationService;
    @Resource
    private HtCertificationDao htCertificationDao;

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

    @GetMapping("/htCertificationList")
    public String toUserList(Model model){
        List<CertificationModel> listAll = htCertificationDao.getCertification();
        model.addAttribute("list",listAll);
        return "admin/certification_list";
    }
}
