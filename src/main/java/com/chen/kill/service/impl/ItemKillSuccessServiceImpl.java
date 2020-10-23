package com.chen.kill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.kill.dao.ItemKillSuccessDao;
import com.chen.kill.entity.ItemKillSuccessEntity;
import com.chen.kill.service.ItemKillSuccessService;
import com.chen.kill.utils.PageUtils;
import com.chen.kill.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("itemKillSuccessService")
public class ItemKillSuccessServiceImpl extends ServiceImpl<ItemKillSuccessDao, ItemKillSuccessEntity> implements ItemKillSuccessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ItemKillSuccessEntity> page = this.page(
                new Query<ItemKillSuccessEntity>().getPage(params),
                new QueryWrapper<ItemKillSuccessEntity>()
        );

        return new PageUtils(page);
    }

}