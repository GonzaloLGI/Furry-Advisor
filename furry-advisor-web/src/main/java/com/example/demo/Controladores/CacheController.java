import java.util.Map;

@RestController
public class CacheController{

    @Autowired
    private CacheManager cacheManager;

    //@CacheConfig(cacheNames="whatever")
    @RequestMappin(value="/cache", method=RequestMethod.GET)
    public Map<Object, Object> getCacheContent(){
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("whatever");
        return cache.getNativeCache();
    }
}