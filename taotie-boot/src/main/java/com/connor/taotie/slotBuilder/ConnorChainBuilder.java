package com.connor.taotie.slotBuilder;

import com.alibaba.csp.sentinel.log.RecordLog;
import com.alibaba.csp.sentinel.slotchain.*;
import com.alibaba.csp.sentinel.util.SpiLoader;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;

import java.util.List;

public class ConnorChainBuilder implements SlotChainBuilder {

    @Override
    public ProcessorSlotChain build() {
        System.out.println("hello");
        ProcessorSlotChain chain = new DefaultProcessorSlotChain();

        // Note: the instances of ProcessorSlot should be different, since they are not stateless.
        List<ProcessorSlot> sortedSlotList = SpiLoader.loadPrototypeInstanceListSorted(ProcessorSlot.class);
        for (ProcessorSlot slot : sortedSlotList) {
            if (!(slot instanceof AbstractLinkedProcessorSlot)) {
                RecordLog.warn("The ProcessorSlot(" + slot.getClass().getCanonicalName() + ") is not an instance of AbstractLinkedProcessorSlot, can't be added into ProcessorSlotChain");
                continue;
            }

            chain.addLast((AbstractLinkedProcessorSlot<?>) slot);
        }

        return chain;
    }
}
