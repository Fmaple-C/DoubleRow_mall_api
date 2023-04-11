package com.mall.doublerow.service.impl;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.doublerow.entity.vo.UmsMemberVo;
import com.mall.doublerow.mapper.UmsMemberMapper;
import com.mall.doublerow.model.UmsMember;
import com.mall.doublerow.service.UmsMemberService;
import java.util.Collections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UmsMemberServiceImpl
 * @Description TODO
 * @Date 2023/3/29 20:29
 * @Version 1.0
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService{

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public Map<String, Object> login(UmsMemberVo umsMemberVo) {
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        wrapper.select("id","nickname","phone","icon","gender","birthday","city","job","personalized_signature")
                .eq("username",umsMemberVo.getUsername())
                .eq("password",umsMemberVo.getPassword());
        List<Map<String, Object>> maps = umsMemberMapper.selectMaps(wrapper);
        if (maps.size() == 1) {
            Map<String, Object> map = maps.get(0);
            StpUtil.login(map.get("id"), SaLoginConfig
                    .setExtra("memberId",map.get("id"))
                    .setExtra("nickname",map.get("nickname"))
            );
            map.put("token",StpUtil.getTokenValue());
            return map;
        }
        return Collections.emptyMap();
    }

    @Override
    public int register(UmsMemberVo umsMemberVo) {
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        wrapper.eq("username",umsMemberVo.getUsername());
        UmsMember selectOne = umsMemberMapper.selectOne(wrapper);
        if (selectOne != null) {
            return 0;
        }
        else {
            UmsMember umsMember = new UmsMember();
            BeanUtils.copyProperties(umsMemberVo,umsMember);
            return umsMemberMapper.insert(umsMember);
        }
    }
}
