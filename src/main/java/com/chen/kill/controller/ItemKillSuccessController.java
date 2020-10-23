package com.chen.kill.controller;

import com.chen.kill.entity.ItemKillSuccessEntity;
import com.chen.kill.service.ItemKillSuccessService;
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
 * 秒杀成功订单表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@RestController
@RequestMapping("kill/itemkillsuccess")
public class ItemKillSuccessController {
    @Autowired
    private ItemKillSuccessService itemKillSuccessService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = itemKillSuccessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{code}")
    public R info(@PathVariable("code") String code){
		ItemKillSuccessEntity itemKillSuccess = itemKillSuccessService.getById(code);

        return R.ok().put("itemKillSuccess", itemKillSuccess);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ItemKillSuccessEntity itemKillSuccess){
		itemKillSuccessService.save(itemKillSuccess);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ItemKillSuccessEntity itemKillSuccess){
		itemKillSuccessService.updateById(itemKillSuccess);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody String[] codes){
		itemKillSuccessService.removeByIds(Arrays.asList(codes));

        return R.ok();
    }

}
