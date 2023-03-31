package com.mall.doublerow.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.mall.doublerow.entity.dto.PmsProductCategoryNodeDto;
import com.mall.doublerow.entity.vo.PmsProductVo;
import com.mall.doublerow.mapper.PmsProductCategoryMapper;
import com.mall.doublerow.mapper.PmsProductMapper;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.model.PmsProductCategory;
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
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Override
    public List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort) {
        PageHelper.startPage(pageNum, pageSize);

        return null;
    }

    @Override
    public List<PmsProductCategoryNodeDto> categoryTreeList() {
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        List<PmsProductCategory> allList = pmsProductCategoryMapper.selectList(wrapper);
        List<PmsProductCategoryNodeDto> result = allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public PmsProduct detail(Long id) {
        return null;
    }

    /**
     * 初始对象转化为节点对象
     */
    private PmsProductCategoryNodeDto covert(PmsProductCategory item, List<PmsProductCategory> allList) {
        PmsProductCategoryNodeDto node = new PmsProductCategoryNodeDto();
        BeanUtils.copyProperties(item, node);
        List<PmsProductCategoryNodeDto> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
