package com.chen.kill.service.impl;

import com.chen.kill.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.kill.dao.RandomCodeDao;
import com.chen.kill.entity.RandomCodeEntity;
import com.chen.kill.service.RandomCodeService;
import com.chen.kill.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("randomCodeService")
public class RandomCodeServiceImpl extends ServiceImpl<RandomCodeDao, RandomCodeEntity> implements RandomCodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RandomCodeEntity> page = this.page(
                new Query<RandomCodeEntity>().getPage(params),
                new QueryWrapper<RandomCodeEntity>()
        );

        return new PageUtils(page);
    }

}