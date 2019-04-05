package cn.savory.app.localtor;

import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author harriszhang
 * @date 2018/12/6.
 */
public class SavoryRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public SavoryRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {

        Map<String, ZuulProperties.ZuulRoute> maps = new LinkedHashMap<>();

        ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
        zuulRoute.setId("a1");
        zuulRoute.setPath("/post/*");
        zuulRoute.setServiceId("sid");
        zuulRoute.setStripPrefix(false);
        zuulRoute.setCustomSensitiveHeaders(false);
        zuulRoute.setUrl("https://www.harriszhang.com/");
        maps.put("/post/*", zuulRoute);

        return maps;
    }

    @Override
    public void refresh() {


        System.out.println("refresh() is called.");
        super.doRefresh();
    }
}
