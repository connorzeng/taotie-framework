package com.connor.taotieboot.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SentinelEchoController {


    @PostConstruct
    public void init() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("/sentinel")
    public String echo() {

        Entry entry = null;
        try {
            entry = SphU.entry("HelloWorld");
            // 资源中的逻辑.
            System.out.println("hello world");
            return "hello";
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
            entry = SphU.entry("HelloWorld");
            // 资源中的逻辑.
            System.out.println("hello world");
            return "hello";
        } catch (BlockException ex) {
            ex.printStackTrace();
            return "error";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }
}
