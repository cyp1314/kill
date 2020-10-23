package com.chen.kill.controller;

import com.chen.kill.entity.ItemKillEntity;
import com.chen.kill.service.ItemKillService;
import com.chen.kill.utils.PageUtils;
import com.chen.kill.utils.R;
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



/**
 * 待秒杀商品表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@RestController
@RequestMapping("kill/itemkill")
public class ItemKillController {
    @Autowired
    private ItemKillService itemKillService;

    @GetMapping("/{id}")
    public R kill(@PathVariable("id") String id) throws InterruptedException {
        Boolean flag = itemKillService.kill(id);
        return flag?R.ok():R.error(1000,"库存不足！");
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = itemKillService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ItemKillEntity itemKill = itemKillService.getById(id);

        return R.ok().put("itemKill", itemKill);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ItemKillEntity itemKill){
		itemKillService.save(itemKill);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ItemKillEntity itemKill){
		itemKillService.updateById(itemKill);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		itemKillService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
