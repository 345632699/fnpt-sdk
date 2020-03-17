package com.wuyi.express.fnpt.service;

import java.util.Map;

public interface AmapService {
    Map getLocation(String lat, String lng) throws Exception;

    Map getLatLng(String address) throws Exception;

    Map getDirection(String origin, String destination) throws Exception;
}
