package com.threewater.template.background.controller;

import com.threewater.template.background.domain.ServerSettings;
import com.threewater.template.background.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    private Map<String,Object> params = new HashMap<>();

    /**
     * 功能描述：测试restful协议，从路径中获取字段
     * @param cityId
     * @param userId
     * @return
     */
    @RequestMapping(path = "/api/v1/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId ){
        params.clear();

        params.put("cityId", cityId);
        params.put("userId", userId);

        return params;

    }

    /**
     * 功能描述：测试GetMapping
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value="/api/v1/page_user1")
    public Object pageUser(int  from, int size ){
        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;

    }

    /**
     * 功能描述：默认值，是否必须的参数
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value="/api/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue="0",name="page") int  from, int size ){

        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;

    }

    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     * 		2、使用body传输数据
     * @param userInfo
     * @return
     */
    @RequestMapping("/api/v1/save_user")
    public Object saveUser(@RequestBody UserInfo userInfo){
        params.clear();
        params.put("user", userInfo);
        return params;
    }

    /**
     * 功能描述：测试获取http头信息
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/api/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id){
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    @PostMapping("/api/v1/test_request")
    public Object testRequest(HttpServletRequest request) throws IOException {
        params.clear();
        String id = request.getParameter("id");
//        String sdf = request.getParameter("sdf");
//        String[] ids = request.getParameterValues("id");
//        BufferedReader bf = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        String line;
//        StringBuilder sb = new StringBuilder();
//        while((line= bf.readLine()) != null){
//            sb.append(line);
//        }
        params.put("id", id);
        return params;
    }

    /**
     * 功能描述：测试PostMapping
     * @param id
     * @param pwd
     * @return
     */
    @PostMapping("/api/v1/")
    public Object login(String id, String pwd){
        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);
        return params;
    }

    @PutMapping("/api/v1/put")
    public Object put(String id){
        params.clear();
        params.put("id", id);
        return params;
    }


    @DeleteMapping("/api/v1/del")
    public Object del(String id){
        params.clear();
        params.put("id", id);
        return params;
    }

    @GetMapping("/api/v1/get_json")
    public Object getJson(){

        return new UserInfo("12", "abc123", new Date());
    }

    @Autowired
    private ServerSettings serverSettings;

    @RequestMapping(path="/api/v1/getServerSetting", method=RequestMethod.GET)
    public Object getServerSetting(){
        return serverSettings;
    }
}
