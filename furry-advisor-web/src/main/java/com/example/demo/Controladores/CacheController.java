package com.example.demo.Controladores;

import com.hazelcast.spring.cache.HazelcastCache;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CacheController{

    @Autowired
    private CacheManager cacheManager;

    //PlaceType Cache
    @RequestMapping(value="/cachePlacetype", method=RequestMethod.GET)
    public Map<Object, Object> getCachePlacetype(){
        HazelcastCacheManager cacheMgr = (HazelcastCacheManager) cacheManager;
        HazelcastCache cache = (HazelcastCache) cacheMgr.getCache("placetype");
        return cache.getNativeCache();
    }

    //Location Cache
    @RequestMapping(value="/cacheLocation", method=RequestMethod.GET)
    public Map<Object, Object> getCacheLocation(){
        HazelcastCacheManager cacheMgr = (HazelcastCacheManager) cacheManager;
        HazelcastCache cache = (HazelcastCache) cacheMgr.getCache("location");
        return cache.getNativeCache();
    }

    //Places Cache
    @RequestMapping(value="/cachePlaces", method=RequestMethod.GET)
    public Map<Object, Object> getCachePlaces(){
        HazelcastCacheManager cacheMgr = (HazelcastCacheManager) cacheManager;
        HazelcastCache cache = (HazelcastCache) cacheMgr.getCache("places");
        return cache.getNativeCache();
    }
}