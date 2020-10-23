package com.chen.kill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.kill.dao.ItemKillDao;
import com.chen.kill.dao.ItemKillSuccessDao;
import com.chen.kill.entity.ItemKillEntity;
import com.chen.kill.entity.ItemKillSuccessEntity;
import com.chen.kill.service.ItemKillService;
import com.chen.kill.utils.PageUtils;
import com.chen.kill.utils.Query;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service("itemKillService")
public class ItemKillServiceImpl extends ServiceImpl<ItemKillDao, ItemKillEntity> implements ItemKillService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    ItemKillSuccessDao itemKillSuccessDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ItemKillEntity> page = this.page(
                new Query<ItemKillEntity>().getPage(params),
                new QueryWrapper<ItemKillEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public Boolean kill(String id){

        Boolean f = false;


        RLock lock = redissonClient.getLock(id);

        try {
            boolean b = lock.tryLock(30, 10, TimeUnit.SECONDS);
            if (b) {
                ItemKillEntity itemKillEntity = this.baseMapper.selectById(id);
                if (itemKillEntity != null && itemKillEntity.getTotal() > 0) {
                    // 扣库存
                    itemKillEntity.setTotal(itemKillEntity.getTotal() - 1);
                    int i = this.baseMapper.updateById(itemKillEntity);
                    if (i > 0) {
                        // 写入订单表
                        writeOrder(id);
                        f = true;
                    }
                }
            }
        } catch (Exception e){

        } finally {
            lock.unlock();
        }

        return f;
    }

    public void writeOrder(String id) {
        ItemKillSuccessEntity entity = new ItemKillSuccessEntity();
        entity.setCode(UUID.randomUUID().toString());
        entity.setItemId(Integer.parseInt(id));
        entity.setKillId(Integer.parseInt(id));
        entity.setUserId("1");
        entity.setStatus(1);
        entity.setCreateTime(new Date());

        int insert = itemKillSuccessDao.insert(entity);
    }

}