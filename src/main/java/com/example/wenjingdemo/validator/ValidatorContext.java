package com.example.wenjingdemo.validator;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: ValidatorContext为请求上下文，与当前请求线程绑定，继承自ConcurrentHashMap，requestDto属性为接口请求入参对象，提供get/set方法使得在上下文中能更加便捷的获取请求入参数据。
 * @date 2021/8/31 4:47 下午
 */
public class ValidatorContext extends ConcurrentHashMap<String, Object> {

    /**
     * 请求对象
     */
    public Object requestDto;

    protected static final ThreadLocal<? extends ValidatorContext> threadLocal = ThreadLocal.withInitial(ValidatorContext::new);

    /**
     * 获取当前线程的上下文
     * @return
     */
    public static ValidatorContext getCurrentContext(){
        return threadLocal.get();
    }

    /**
     * 设值
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        if (value != null) {
            put(key, value);
        } else {
            remove(key);
        }
    }

    /**
     * 获取String值
     * @param key
     * @return
     */
    public String getStr(String key){
        return String.valueOf(get(key));
    }

    /**
     * 获取Integer值
     * @param key
     * @return
     */
    public Integer getInteger(String key){
        return (Integer) get(key);
    }

    /**
     * 获取对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObj(String key){
        return (T) get(key);
    }

    /**
     * 获取Long值
     * @param key
     * @return
     */
    public Long getLong(String key){
        return (Long) get(key);
    }

    /**
     * 获取入参对象
     * @param <T>
     * @return
     */
    public <T> T getRequestDto(){
        return (T) requestDto;
    }

    public void setRequestDto(Object req){
        this.requestDto = req;
    }
}
