package com.songyang.question;

/**
 * @author Yang Song
 * @date 2022/7/29 19:32
 */
public class Q677 {
    /**
     * 设计一个 map ，满足以下几点:
     *
     * 字符串表示键，整数表示值
     * 返回具有前缀等于给定字符串的键的值的总和
     * 实现一个 MapSum 类：
     *
     * MapSum() 初始化 MapSum 对象
     * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
     * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和
     */
    String[] key;
    int[] val;
    int count = 0;
    public Q677() {
        key = new String[100];
        val = new int[100];
    }

    public void insert(String key, int val) {
        for(int i = 0;i < this.key.length;i++){
            if(key.equals(this.key[i])){
                this.key[i] = key;
                this.val[i] = val;
                return;
            }
        }
        this.key[count] = key;
        this.val[count] = val;
        ++count;
    }

    public int sum(String prefix) {
        int sum = 0;
        for (int i = 0;i < count;i++){
            if(key[i].startsWith(prefix)){
                sum += val[i];
            }
        }
        return sum;
    }
}
