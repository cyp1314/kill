### 分布式锁使用
```
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
```
