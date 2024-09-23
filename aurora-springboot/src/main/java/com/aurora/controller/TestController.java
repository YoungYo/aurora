package com.aurora.controller;

import com.alibaba.fastjson.JSONObject;
import com.aurora.model.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/gt-live-motor/test/")
public class TestController {


    @RequestMapping("showHeaders")
    public ResultVO<Map<String, String>> createGroup(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        // 使用 while 循环遍历 Enumeration
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            headers.put(element, request.getHeader(element));
        }
        log.info("realip: {}, query tring: {}, TestControllerHeaders: {}", request.getRemoteAddr(), request.getQueryString(), JSONObject.toJSONString(headers));
        return ResultVO.ok(headers);
    }
}
