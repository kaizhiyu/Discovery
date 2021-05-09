package com.nepxion.discovery.plugin.strategy.zuul.route;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;

import com.nepxion.discovery.common.apollo.proccessor.ApolloProcessor;
import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.strategy.zuul.constant.ZuulStrategyConstant;

public class ZuulRouteApolloProcessor extends ApolloProcessor {
    @Autowired
    private PluginAdapter pluginAdapter;

    @Autowired
    private ZuulStrategyRoute zuulStrategyRoute;

    @Override
    public String getGroup() {
        return pluginAdapter.getGroup();
    }

    @Override
    public String getDataId() {
        return pluginAdapter.getServiceId() + "-" + ZuulStrategyConstant.ZUUL_DYNAMIC_ROUTE;
    }

    @Override
    public String getDescription() {
        return ZuulStrategyConstant.ZUUL_DYNAMIC_ROUTE_DESCRIPTION;
    }

    @Override
    public void callbackConfig(String config) {
        zuulStrategyRoute.updateAll(config);
    }
}