package com.gongsi.mycoin.vo.page;

import com.gongsi.mycoin.vo.BaseVO;
import lombok.Data;

/**
 * Created by 吴宇 on 2018-06-03.
 */
@Data
public class PageVO extends BaseVO {
    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
}
