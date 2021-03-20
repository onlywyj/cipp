package com.wyj.cipp.service;

import java.util.Map;

public interface HtCertificationService {
    public Map getCertification(String session);

    public Map certification( String session, String id, String agree);
}
