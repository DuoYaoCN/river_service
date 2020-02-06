package com.river.service.impl;

import com.river.domain.Scenery;
import com.river.dependence.Verify;
import com.river.service.ImageService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class ImageServiceImpl implements ImageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Scenery verifySense(byte[] image) {
        Scenery scenery = new Scenery();
        HashMap<String, String> options = new HashMap<String, String>();
        // 参数为本地路径
        JSONObject res = Verify.getInstance().landmark(image, options);
        scenery.setLog_id(res.toString(0));
        scenery.setResult(res.toString(1));
        scenery.setLandmark(res.toString(2));
        System.out.println(res);
        return scenery;
    }
}
