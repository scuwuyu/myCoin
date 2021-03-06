package com.gongsi.mycoin.controllers;

import com.alibaba.fastjson.JSON;
import com.gongsi.mycoin.services.MemberTypeService;
import com.gongsi.mycoin.utils.UserUtil;
import com.gongsi.mycoin.vo.MemberTypeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 会员套餐
 * Created by 吴宇 on 2018-06-03.
 */
@Slf4j
@Controller
@RequestMapping("/mini/member")
public class MemberController {

    @Autowired
    private MemberTypeService memberTypeService;

    /** 会员套餐列表 */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public List<MemberTypeVO> list(@RequestBody MemberTypeVO vo){
        log.info("会员套餐列表vo={}", UserUtil.getUser(vo.getKey()));
        return memberTypeService.selectList();
    }

    /** 购买套餐 */
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    @ResponseBody
    public MemberTypeVO buy(@RequestBody MemberTypeVO vo){
        log.info("会员购买套餐vo={}", JSON.toJSONString(vo));
        return memberTypeService.buy(vo,UserUtil.getUser(vo.getKey()));
    }
}
