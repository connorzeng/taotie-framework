package com.connor.taotie.dependency.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 层级关系:
 * 1. 线程上下文
 *      threadId: context
 * 2. 线程context内部key:value
 *      beanName: bean
 */
public class ThreadlocalScope implements Scope {

    public static final String SCOPE_NAME = "threadlocalScope";

    /**
     * 命名
     */
    private static String THRAED_NAME = "threadlocalScope";

    /**
     *
     * 定义一个上下文维护线程上下文的bean
     */
    private static final NamedThreadLocal<Map<String, Object>> CONTEXT = new NamedThreadLocal(THRAED_NAME){
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        // 1. 先从上下文中获取
        Object obj = getStringObjectMap().get(name);
        if (obj != null) {
            return obj;
        }

        // 2. 从beanFactory获取,并且在上下文中维护.
        // 特别注意: obj不会无中生有,最终还是从Spring上下文获取
        obj = objectFactory.getObject();
        if (obj != null) {
            getStringObjectMap().put(name, obj);
        }
        return obj;
    }

    /**
     * 这里要防止NPE
     *
     * @return
     */
    private Map<String, Object> getStringObjectMap() {
//        Map<String, Object> stringObjectMap = CONTEXT.get();
//
//        if (stringObjectMap == null) {
//            stringObjectMap = new HashMap<>();
//            CONTEXT.set(stringObjectMap);
//        }

        // 已经有初始化方法,这里直接返回
        return CONTEXT.get();
    }

    /**
     * 删除上下文的obj
     *
     * @param name
     * @return
     */
    @Override
    public Object remove(String name) {

        Object obj = getStringObjectMap().get(name);

        if (obj != null) {
            getStringObjectMap().remove(name);
        }

        return obj;
    }

    /**
     * 销毁回调,这个不知道在哪里进行调用 TODO
     *
     * @param name
     * @param callback
     */
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    /**
     * 返回scope的上下文,这里就是返回context
     *
     * @param key
     * @return
     */
    @Override
    public Object resolveContextualObject(String key) {
        return CONTEXT;
    }


    @Override
    public String getConversationId() {
        return THRAED_NAME + ":" + Thread.currentThread().getId();
    }
}
