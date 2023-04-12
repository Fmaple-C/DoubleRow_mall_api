package com.mall.doublerow.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.mall.doublerow.entity.dto.PmsPortalProductDetail;
import com.mall.doublerow.entity.dto.PmsProductCategoryNode;
import com.mall.doublerow.mapper.*;
import com.mall.doublerow.model.*;
import com.mall.doublerow.service.PmsProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    @Autowired
    private PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Override
    public List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0)
                .eq("publish_status",1);
        if (StrUtil.isNotEmpty(keyword))
            wrapper.like("name",keyword);
        if (brandId != null)
            wrapper.eq("brand_id",brandId);
        if (productCategoryId != null) {
            wrapper.eq("product_category_id",productCategoryId);
        }
        //1->按新品；2->按销量；3->价格从低到高；4->价格从高到低
        if (sort == 1) {
            wrapper.orderByDesc("id");
        } else if (sort == 2) {
            wrapper.orderByDesc("sale");
        } else if (sort == 3) {
            wrapper.orderByDesc("price");
        } else if (sort == 4) {
            wrapper.orderByAsc("price");
        }
        return pmsProductMapper.selectList(wrapper);
    }

    @Override
    public List<PmsProductCategoryNode> categoryTreeList() {
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        List<PmsProductCategory> allList = pmsProductCategoryMapper.selectList(wrapper);
        return allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList))
                .collect(Collectors.toList());
    }

    @Override
    public PmsPortalProductDetail detail(Long id) {
        PmsPortalProductDetail result = new PmsPortalProductDetail();
        //获取商品信息
        PmsProduct pmsProduct = pmsProductMapper.selectById(id);
        result.setProduct(pmsProduct);
        //获取商品属性信息
        QueryWrapper<PmsProductAttribute> wrapper = new QueryWrapper<>();
        wrapper.eq("product_attribute_category_id",pmsProduct.getProductAttributeCategoryId());
        List<PmsProductAttribute> pmsProductAttributes = pmsProductAttributeMapper.selectList(wrapper);
        result.setProductAttributeList(pmsProductAttributes);
        //获取商品属性值信息
        if (CollUtil.isNotEmpty(pmsProductAttributes)) {
            QueryWrapper<PmsProductAttributeValue> productAttributeValueQueryWrapper = new QueryWrapper<>();
            productAttributeValueQueryWrapper.eq("product_id",pmsProduct.getId());
            List<PmsProductAttributeValue> pmsProductAttributeValues = pmsProductAttributeValueMapper.selectList(productAttributeValueQueryWrapper);
            result.setProductAttributeValueList(pmsProductAttributeValues);
        }
        return result;
    }

    /**
     * 初始对象转化为节点对象
     */
    private PmsProductCategoryNode covert(PmsProductCategory item, List<PmsProductCategory> allList) {
        PmsProductCategoryNode node = new PmsProductCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<PmsProductCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
