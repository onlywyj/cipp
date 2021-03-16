package com.wyj.cipp.service;

import java.util.Map;

public interface HtCommentService {

    public Map getComment(String session);

    public Map delComment(String session, String id);
}
