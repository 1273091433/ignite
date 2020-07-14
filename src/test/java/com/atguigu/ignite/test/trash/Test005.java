package com.atguigu.ignite.test.trash;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import java.util.Arrays;

/**
 * @Classname Test005
 * @Description TODO
 * @Date 2020/7/13 22:21
 * @Created by 86153
 */
public class Test005 {
    public static void main(String[] args) {
        {
            //创建一个TCP Discovery SPI实例
            TcpDiscoverySpi spi = new TcpDiscoverySpi();

            //创建一个tcp discovery multicast ip finder实例
            TcpDiscoveryMulticastIpFinder tcMP = new TcpDiscoveryMulticastIpFinder();
            tcMP.setAddresses(Arrays.asList("hadoop102"));//添加主机地址
            spi.setIpFinder(tcMP);

            IgniteConfiguration cfg = new IgniteConfiguration();
            cfg.setClientMode(false);

            cfg.setDiscoverySpi(spi);

            try (Ignite ignite = Ignition.start(cfg)) {
                IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

                for (int i = 0; i < 10; i++)
                    System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }

        }
    }
}
