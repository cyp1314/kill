package com.chen.kill.controller;

import com.chen.kill.entity.RandomCodeEntity;
import com.chen.kill.service.RandomCodeService;
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
 * 
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@RestController
@RequestMapping("kill/randomcode")
public class RandomCodeController {
    @Autowired
    private RandomCodeService randomCodeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = randomCodeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		RandomCodeEntity randomCode = randomCodeService.getById(id);

        return R.ok().put("randomCode", randomCode);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody RandomCodeEntity randomCode){
		randomCodeService.save(randomCode);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody RandomCodeEntity randomCode){
		randomCodeService.updateById(randomCode);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		randomCodeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
