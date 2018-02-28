package com.siyann.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Utils {
    /**
     * 将结果按格式输出
     *
     * @param code 提示码
     * @param msg  给用户的提示信息，没有则为空串
     * @param data 返回给客户端的数据
     * @return
     */
    public static Map<String, Object> toJson(int code, String msg, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public final static String ERROR = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xml><return_msg>校验失败，请重试</return_msg><return_code>FAIL</return_code></xml>";

    /**
     * 生成6位随机数
     *
     * @return
     */
    public static String ran6() {
        Double a = 100000 + Math.random() * 899999;
        return "" + a.intValue();
    }

    /**
     * 生成4位随机数
     *
     * @return
     */
    public static String ran4() {
        Double a = 1000 + Math.random() * 8999;
        return "" + a.intValue();
    }

    /**
     * 转换Int
     */
    public static Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 实体转Map
     */
    public static LinkedHashMap<String, Object> objectToMap(Object obj)
            throws Exception {
        if (obj == null) {
            return null;
        }

        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    public static String getFileUrl(String realBasePath,
                                    CommonsMultipartFile file, Long time, String path) throws Exception{
        try {
            if (file.getOriginalFilename().equals("")) {
                return null;
            }
            String filename = time + "_" + file.getOriginalFilename();
            String filePath = realBasePath + path.replace("/", File.separator)
                    + File.separator + filename;
            File newFile = new File(filePath);
            if (!newFile.getParentFile().exists()) {
                System.out.println("目标文件的目录不存在，准备创建目录...");
                if (!newFile.getParentFile().mkdirs()) {
                    System.out.println("创建目录失败");
                    throw new Exception();
                }
            }
            // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            return path + "/" + filename;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
