package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtCertificationDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CertificationModel;
import com.wyj.cipp.service.HtCertificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtCertificationServiceImpl implements HtCertificationService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private HtCertificationDao htCertificationDao;

    @Override
    public Map getCertification(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<CertificationModel> certification = htCertificationDao.getCertification();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htCertificationDao.countCertification());
                map.put("data",certification);
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map certification(String session, String id, String agree) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htCertificationDao.certification(id,agree);
                if (i>0 && agree.equals("同意")){
                    Map department = htCertificationDao.getDepartment(id);
                    htCertificationDao.updateCertification(department.get("application_sector").toString(),
                            department.get("original_name").toString());

                }
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"成功":"失败");
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }
}
