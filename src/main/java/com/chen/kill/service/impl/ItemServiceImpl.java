package com.chen.kill.service.impl;

import com.chen.kill.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.kill.dao.ItemDao;
import com.chen.kill.entity.ItemEntity;
import com.chen.kill.service.ItemService;
import com.chen.kill.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("itemService")
public class ItemServiceImpl extends ServiceImpl<ItemDao, ItemEntity> implements ItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ItemEntity> page = this.page(
                new Query<ItemEntity>().getPage(params),
                new QueryWrapper<ItemEntity>()
        );

        return new PageUtils(page);
    }

}