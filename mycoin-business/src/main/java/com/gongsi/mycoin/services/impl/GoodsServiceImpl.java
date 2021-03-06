package com.gongsi.mycoin.services.impl;

import com.gongsi.mycoin.core.Pagination;
import com.gongsi.mycoin.core.ensure.Ensure;
import com.gongsi.mycoin.core.utils.BeanMapper;
import com.gongsi.mycoin.dao.GoodsMapper;
import com.gongsi.mycoin.entities.Goods;
import com.gongsi.mycoin.services.GoodsService;
import com.gongsi.mycoin.vo.GoodsVO;
import com.gongsi.mycoin.vo.UserSessionVO;
import com.gongsi.mycoin.vo.page.GoodsPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 吴宇 on 2018-05-26.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /** 新增商品 */
    public void add(GoodsVO vo, UserSessionVO user){
        Goods goods = BeanMapper.map(vo, Goods.class);
        goods.setUserId(user.getUserId());

        Integer result = goodsMapper.insertSelective(goods);
        Ensure.that(result).isEq(1,"商品保存失败");
    }

    /** 商品分页查询*/
    public Pagination<GoodsVO> selectList(GoodsPageVO vo, UserSessionVO user){
        Pagination<GoodsVO> pagination = new Pagination<>(vo.getCurrentPage(),vo.getPageSize());
        int count = goodsMapper.countList(vo,user.getUserId());
        pagination.setTotalCount(count);
        if (count == 0){
            return pagination;
        }

        List<GoodsVO> list = goodsMapper.selectList(vo,user.getUserId(),pagination);
        pagination.setList(list);

        return pagination;
    }
    /** 删除商品 */
    @Transactional
    public void delete(List<Long> goodsIds, UserSessionVO user){
        Ensure.that(goodsIds).isNotEmpty("商品id不能为空");
        int result = goodsMapper.delete(goodsIds,user.getUserId());
        Ensure.that(result).isEq(goodsIds.size(),"删除失败，请刷新重试");
    }

    public List<GoodsVO> selectByIds(List<Long> goodsIds){
        return goodsMapper.selectByIds(goodsIds);
    }
}
