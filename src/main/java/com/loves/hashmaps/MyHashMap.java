package com.loves.hashmaps;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/13
 */
public class MyHashMap<K,V> implements  MyMap<K,V>{
    //定义默认数组大小16 defaulAddSizeFactor = useSize/defaulLenth 4/16 =0.25
    private static  int defaulLenth = 1 << 4;
    //扩容标准所使用的useSize / 数组长度> 0.75
    //defaulAddSizeFactor过大 造成扩容概率变低 存储小 但是就是存和取效率降低
    //0.9有限的数组长度空间位置内会形成链表 在存或取值都需要进行大量的遍历和判断逻辑
    private static double defaulAddSizeFactor = 0.75;
    //使用数组位置的总是  使用volatile可见行性操作 将不会存在处理器 的特定内存当中 内存是其他线程不可见的
    private volatile int useSize;
    //定义Map 骨架只要数组之一数组
    private Entry<K,V>[] table = null;
    //扩容之后的数组
    private Entry<K,V> [] newTable = null;
    //spring门面模式运用
    public MyHashMap(){
        this(defaulLenth,defaulAddSizeFactor);
    }

    public MyHashMap(int length,double defaulAddSizeFactor){
        if(length < 0){
            throw new IllegalArgumentException("参数不能为负数"+length);
        }
        if(defaulAddSizeFactor <=0 || Double.isNaN(defaulAddSizeFactor)){
            throw new IllegalArgumentException("扩容标准必须是大与0的数字"+defaulAddSizeFactor);
        }
        this.defaulLenth = length;
        this.defaulAddSizeFactor = defaulAddSizeFactor;
        //内存当中划分连续的内存空间
        table = new Entry[defaulLenth];

    }


    @Override
    public V put(K k, V v) {
       //判断是否扩容
       if(useSize > defaulAddSizeFactor * defaulLenth){
           up2Size();
       }
       // 获取数组位置
       int index = getIndex(k, table.length);

       Entry<K,V> entry = table[index];
       if(entry == null){
           //存储在数组和链表当中 的数据结构对象
           table[index] = new Entry(k,v,null);
           useSize++;
       }else if(entry != null){
           table[index] = new Entry(k,v, entry);
       }
       return table[index].getValue();
    }

    //获取位置 定位
    private int getIndex(K k, int length) {
        int m = length -1;
        int index = hash(k.hashCode()) & m;
        return index;
    }

    //hash算法
    //jdk大量的数学算法后确定了这四个数字
    private int hash(int hashCode){
        hashCode = hashCode^((hashCode >>> 20) ^(hashCode >>> 12));
        return hashCode^((hashCode >>> 7) ^(hashCode >>> 4));
    }

    //数组扩容
    private void up2Size() {
        newTable = new Entry[2 * defaulLenth];
        //将老数组的内容再次散列hash到新数组
        againHash(newTable);
    }

    private void againHash(MyHashMap<K,V>.Entry<K, V>[] newTable) {

        List<Entry<K,V>> entryList =new ArrayList<>();
        //for循环出来就代表内容全部遍历到entryList中
        for(int i=0;i<table.length ; i++){
            if(table[i] == null){
                continue;
            }
            //继续找到存在数组上的Entry对象
            foundEntryByNext(table[i], entryList);
        }
        //设置entryList
        if(entryList.size() > 0){
            defaulLenth = 2* defaulLenth;
            for(Entry<K,V> entry: entryList){
                if(entry.next != null){
                    entry.next = null;
                }
                useSize = 0;
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void foundEntryByNext(Entry<K, V> entry, List<Entry<K, V>> entryList) {
        if(entry != null && entry.next !=null){
            entryList.add(entry);
            //递归 不断的一层一层存取entry
            foundEntryByNext(entry.next, entryList);
        }else{
            //没有链表的情况
            entryList.add(entry);
        }
    }

    @Override
    public V get(K k) {
        return null;
    }

    //创建一个内部存储对象类型
    class Entry<K,V> implements  MyMap.Entry<K,V>{
        //外界传进封装双列数据 key value
        K k;
        V v;
        //指向被this挤压下去的Entry对象
        Entry<K,V> next;

        public Entry(K k, V v, Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.next =next;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }
}
