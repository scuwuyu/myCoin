package com.gongsi.mycoin.services.http;

import com.gongsi.mycoin.services.http.base.BaseResult;
import lombok.Data;

/**
 * Created by 吴宇 on 2018-06-04.
 */
@Data
public class WechatAuthResult extends BaseResult{
    private String openid;

    private String session_key;
}
