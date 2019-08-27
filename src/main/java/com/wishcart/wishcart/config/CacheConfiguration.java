package com.wishcart.wishcart.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@Slf4j
@RequiredArgsConstructor
public class CacheConfiguration {
	/*
	 * private final Environment env;
	 * 
	 * @PreDestroy public void destroy() { log.info("Closing Cache Manager"); Hazelcast.shutdownAll(); }
	 * 
	 * 
	 * @Bean public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
	 * log.debug("Starting HazelcastCacheManager"); CacheManager cacheManager = new
	 * com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance); return cacheManager; }
	 * 
	 * @Bean public HazelcastInstance hazelcastInstance(WishCartProperties wishCartProperties){
	 * log.debug("Configuring Hazelcast"); HazelcastInstance hazelCastInstance =
	 * Hazelcast.getHazelcastInstanceByName("wish-cart"); if (hazelCastInstance != null) {
	 * log.debug("Hazelcast already initialized"); return hazelCastInstance; } Config config = new Config();
	 * config.setInstanceName("wish-cart"); config.getNetworkConfig().setPort(5701);
	 * config.getNetworkConfig().setPortAutoIncrement(true); config.getMapConfigs().put("default",
	 * initializeDefaultMapConfig()); return Hazelcast.newHazelcastInstance(config); }
	 * 
	 * private MapConfig initializeDefaultMapConfig() { MapConfig mapConfig = new MapConfig();
	 * 
	 *//*
		 * Number of backups. If 1 is set as the backup-count for example, then all entries of the map will be copied to
		 * another JVM for fail-safety. Valid numbers are 0 (no backup), 1, 2, 3.
		 *//*
			 * mapConfig.setBackupCount(0);
			 * 
			 *//*
				 * Valid values are: NONE (no eviction), LRU (Least Recently Used), LFU (Least Frequently Used). NONE is
				 * the default.
				 *//*
					 * mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
					 * 
					 *//*
						 * Maximum size of the map. When max size is reached, map is evicted based on the policy
						 * defined. Any integer between 0 and Integer.MAX_VALUE. 0 means Integer.MAX_VALUE. Default is
						 * 0.
						 *//*
							 * mapConfig.setMaxSizeConfig(new MaxSizeConfig(0,
							 * MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));
							 * 
							 * return mapConfig; }
							 */
}
