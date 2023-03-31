package com.mall.doublerow.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.mall.doublerow.entity.vo.PmsProductVo;
import com.mall.doublerow.mapper.PmsProductMapper;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PmsProductServiceImpl
 * @Description TODO
 * @Date 2023/3/29 20:24
 * @Version 1.0
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;


    @Override
    public List<PmsProduct> list(String keyword) {

        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.like("name",keyword)
                .or()
                .like("sub_title",keyword);
        return pmsProductMapper.selectList(wrapper);
    }

    @Override
    public List<PmsProduct> list(PmsProductVo pmsProductVo, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        if (pmsProductVo.getPublishStatus() != null) {
            wrapper.eq("publish_status",pmsProductVo.getPublishStatus());
        }
        if (pmsProductVo.getVerifyStatus() != null) {
            wrapper.eq("verify_status",pmsProductVo.getVerifyStatus());
        }
        if (!StrUtil.isEmpty(pmsProductVo.getKeyword())) {
            wrapper.like("name",pmsProductVo.getKeyword());
        }
        if (!StrUtil.isEmpty(pmsProductVo.getProductSn())) {
            wrapper.eq("product_sn",pmsProductVo.getProductSn());
        }
        if (pmsProductVo.getBrandId() != null) {
            wrapper.eq("brand_id",pmsProductVo.getBrandId());
        }
        if (pmsProductVo.getProductCategoryId() != null) {
            wrapper.eq("product_category_id",pmsProductVo.getProductCategoryId());
        }
        return pmsProductMapper.selectList(wrapper);
    }
}
