package com.chen.kill.controller;

import com.chen.kill.annotation.SysLog;
import com.chen.kill.entity.ItemEntity;
import com.chen.kill.service.ItemService;
import com.chen.kill.utils.PageUtils;
import com.chen.kill.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 商品表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Slf4j
@RestController
@RequestMapping("kill/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 列表
     */
    @SysLog
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = itemService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ItemEntity item = itemService.getById(id);

        return R.ok().put("item", item);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ItemEntity item){
		itemService.save(item);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ItemEntity item){
		itemService.updateById(item);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		itemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @Autowired
    RedissonClient redissonClient;

    int a = 0;

    @GetMapping("/redisonTest")
    public String redisonTest(){
        RLock lock = redissonClient.getLock("test-a");
        try {
            lock.tryLock(10,50, TimeUnit.SECONDS);
            log.debug("进入锁.");
            for (int i = 1; i < 2; i++) {
                Thread.sleep(1);
                a+=i;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return a+"";
    }

    @GetMapping("/test")
    public String test(){
        try {
            for (int i = 1; i < 2; i++) {
                Thread.sleep(100);
                a+=i;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        }
        return a+"";
    }

}
