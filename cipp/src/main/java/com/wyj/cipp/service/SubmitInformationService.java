package com.wyj.cipp.service;

import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.model.CommentModel;

import java.util.Map;

public interface SubmitInformationService {

    public Map InsertActivity(ActivityModel activityModel);

    public Map insertComment(CommentModel commentModel);

}
