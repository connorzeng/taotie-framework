package com.connor.taotie.provider.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class ModShardingAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {

        //availableTargetNames
        //["ds0","ds1","ds2","ds3"]
        for (Object name : availableTargetNames) {
            int mod = shardingValue.getValue().hashCode() % 4;
            if (name.toString().endsWith(String.valueOf(mod))) {
                return name.toString();
            }
        }

        //没有片键直接返回ds0
        return "ds0";
    }
}
