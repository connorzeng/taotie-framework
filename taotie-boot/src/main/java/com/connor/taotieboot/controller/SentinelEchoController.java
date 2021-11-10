package com.connor.taotieboot.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SentinelEchoController {



    @Value("${connor.name}")
    String connorName;



    @Value("${connorNanme.hello}")
    String connorNanmeHello;




    @PostConstruct
    public void init() {
        List<FlowRule> rules = new ArrayList<>();

        //资源1
        FlowRule rule = new FlowRule();
        rule.setResource("resource1");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);


        //资源2
        rule.setResource("resource2");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);

        //资源3
        rule.setResource("resource3");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);

        DegradeRule rule1 = new DegradeRule();



        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("/sentinel")
    public String echo() {

        Entry entry = null;
        try {
            entry = SphU.entry("resource1");
            // 资源中的逻辑.
            System.out.println("hello world");
            return connorNanmeHello;
        } catch (BlockException ex) {
            ex.printStackTrace();
            return "error";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }


    @RequestMapping("/sentinelA")
    public String echoA() {

        //创建Context
        ContextUtil.enter("entryOne","appA");
        Entry entry = null;
        try {
            entry = SphU.entry("resource1");
            entry = SphU.entry("resource2");
            // 资源中的逻辑.
            System.out.println("hello world");
        } catch (BlockException ex) {
            ex.printStackTrace();
            return "error";
        } finally {
            if (entry != null) {
                entry.exit();
                ContextUtil.exit();
            }
        }


        //创建Context
        ContextUtil.enter("entryTwo","appA");
        Entry entry3 = null;
        try {
            entry3 = SphU.entry("resource3");
            // 资源中的逻辑.
            System.out.println("hello world");
            return "hello";
        } catch (BlockException ex) {
            ex.printStackTrace();
            return "error";
        } finally {
            if (entry != null) {
                entry3.exit();
                ContextUtil.exit();
            }
        }
    }


}
