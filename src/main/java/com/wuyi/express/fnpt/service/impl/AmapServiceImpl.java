package com.wuyi.express.fnpt.service.impl;
import com.wuyi.express.HttpRequestUtils;
import com.wuyi.express.fnpt.service.AmapService;
import com.wuyi.express.fnpt.util.GsonUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AmapServiceImpl implements AmapService {
    private final String key = "0f4e3b6975807deae41eadb8df3b54fc";
    private final String GET_LOCATION_FROM_LAT_LNG = "https://restapi.amap.com/v3/geocode/regeo?parameters";
    private final String GET_DIRECTION = "https://restapi.amap.com/v3/direction/walking";
    private final String GET_LAT_LNG_FROM_LOCATION = "https://restapi.amap.com/v3/geocode/geo";
    @Override
    public Map getLocation(String lat, String lng) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("output", "json");
        map.put("location", lat + "," + lng);
        map.put("key", key);
        String res = HttpRequestUtils.httpGet(GET_LOCATION_FROM_LAT_LNG, map, "");
        Map resMap = GsonUtil.GsonToMaps(res);
        return resMap;
    }

    @Override
    public Map getDirection(String origin, String destination) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("origin", origin);
        map.put("destination", destination);
        map.put("key", key);
        String res = HttpRequestUtils.httpPost(GET_DIRECTION, map);
        return GsonUtil.GsonToMaps(res);
    }

    @Override
    public Map getLatLng(String address) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("address", address);
        map.put("key", key);
        String res = HttpRequestUtils.httpPost(GET_LAT_LNG_FROM_LOCATION, map);
        return GsonUtil.GsonToMaps(res);
    }
}
