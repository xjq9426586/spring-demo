package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/")
public class DataController {
   @RequestMapping(value = "/data", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    public JSONObject index(@RequestBody JSONObject json) {
    	System.out.println(json);
        return json;
    }
   
   @RequestMapping(value = "/data1", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
   public String getByRequest(HttpServletRequest request) {

	    //获取到JSONObject
	    JSONObject jsonParam = this.getJSONParam(request);

	    // 将获取的json数据封装一层，然后在给返回
	    JSONObject result = new JSONObject();
	    result.put("msg", "ok");
	    result.put("method", "request");
	    result.put("data", jsonParam);

	    return result.toJSONString();
	}
   
   public JSONObject getJSONParam(HttpServletRequest request){
	    JSONObject jsonParam = null;
	    try {
	        // 获取输入流
	        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

	        // 写入数据到Stringbuilder
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = streamReader.readLine()) != null) {
	            sb.append(line);
	        }
	        jsonParam = JSONObject.parseObject(sb.toString());
	        // 直接将json信息打印出来
	        System.out.println(jsonParam.toJSONString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return jsonParam;
}
}
