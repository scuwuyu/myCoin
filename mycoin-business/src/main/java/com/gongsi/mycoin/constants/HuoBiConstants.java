package com.gongsi.mycoin.constants;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by 吴宇 on 2018-07-07.
 */
public class HuoBiConstants {
    public static final String  API_HOST = "api.huobi.pro";
    public static final String  API_URL = "https://"+API_HOST;

    /** 行情查询 */
    public static final String  MARKET_HISTORY_KLINE = "/market/history/kline";



    public static final String  appKey = "";
    public static final String  appSecretKey = "";

    public static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
    public static final ZoneId ZONE_GMT = ZoneId.of("Z");

}