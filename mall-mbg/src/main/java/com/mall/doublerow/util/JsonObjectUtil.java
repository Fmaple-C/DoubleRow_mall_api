package com.mall.doublerow.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

/**
 * @ClassName JsonObjectUtil
 * @Description TODO
 * @Date 2023/2/20 14:16
 * @Version 1.0
 */
public class JsonObjectUtil extends FastjsonTypeHandler {
    private final Class<? extends Object> type;

    public JsonObjectUtil(Class<?> type) {
        super(type);
        this.type = type;
    }

    @Override
    protected JSONObject parse(String json) {
        return JSON.parseObject(json);
    }

    @Override
    protected String toJson(Object obj) {
        return super.toJson(obj);
    }
}
