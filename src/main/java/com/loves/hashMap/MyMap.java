package com.loves.hashMap;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/13
 */
public interface MyMap<K, V> {

    //存
    public V put(K k, V v);

    //取
    public V get(K k);

    public interface Entry<K, V> {
        public K getKey();

        public V getValue();
    }
}
