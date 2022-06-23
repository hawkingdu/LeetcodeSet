package javacode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author duhaojun
 * @Date 2022/6/21
 */
public class LFUCache {
    int capacity;
    Map<Integer, CacheEntity> map;
    PriorityQueue<CacheEntity> queue;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        if (capacity > 0) {
            this.queue = new PriorityQueue<>(capacity, (o1, o2) -> {
                if (o1.getUse() == o2.getUse()) {
                    if ((o1.lastUseTS - o2.lastUseTS) >= 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return o1.getUse() - o2.getUse();
                }
            });
        }
        this.map = new HashMap<>();

    }

    public int get(int key) {
        CacheEntity cacheEntity = map.get(key);
        if (cacheEntity==null) {
            return -1;
        } else {
            cacheEntity.use += 1;
            cacheEntity.setLastUseTS(System.nanoTime());
            queue.remove(cacheEntity);
            queue.offer(cacheEntity);
            return cacheEntity.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }
        CacheEntity entity = map.get(key);
        if (entity != null) {
            entity.value = value;
            entity.use += 1;
            entity.setLastUseTS(System.nanoTime());
            queue.remove(entity);
            queue.offer(entity);
        } else {
            while(queue.size()>=capacity){
                CacheEntity poll = queue.poll();
                map.remove(poll.key);
            }
            entity = new CacheEntity(key, value, 1);
            entity.setLastUseTS(System.nanoTime());
            queue.offer(entity);
            map.put(key, entity);
        }
    }

    static class CacheEntity{
        int key;
        int value;
        int use;
        long lastUseTS = System.nanoTime();

        public int getUse() {
            return use;
        }

        public void setLastUseTS(long lastUseTS) {
            this.lastUseTS = lastUseTS;
        }

        public CacheEntity(int key, int value, int use) {
            this.key = key;
            this.value = value;
            this.use = use;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(0);
        System.out.println(lfuCache.get(0));
        lfuCache.put(0,0);
        System.out.println(lfuCache.get(1));
        lfuCache.put(1,5);
        lfuCache.put(1,2);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
//        PriorityQueue<CacheEntity> queue = new PriorityQueue<>(Comparator.comparingInt(CacheEntity::getUse).reversed());
//        queue.offer(new CacheEntity(3,3,3));
//        queue.offer(new CacheEntity(2,2,2));
//        queue.offer(new CacheEntity(1,1,1));
//        System.out.println(queue.poll().use);
    }
}
