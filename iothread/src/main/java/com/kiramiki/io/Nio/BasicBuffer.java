package com.kiramiki.io.Nio;

import java.nio.IntBuffer;

/**
 * @ Author ：kiramiki.
 * @ Date ：Created in 9:22 2022/7/28
 * @ Description ：Basic
 */
public class BasicBuffer {
    public static void main(String[] args) {
        //创建一个大小为5的buffer ，存放int类型
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // Invariants: mark <= position <= limit <= capacity
        //private int mark = -1; 标志位
        //private int position = 0; 当前未知
        //private int limit; 最大长度
        //private int capacity; 存放长度
        // 向buffer 存放数据, capacity为buffer长度
        for(int i = 0 ; i < intBuffer.capacity() ; i++){
            intBuffer.put(i * 2);
        }
        //cap: 5
        //lit: 5
        //pos: 5
        System.out.println("cap: " + intBuffer.capacity());
        System.out.println("lit: " + intBuffer.limit());
        System.out.println("pos: " + intBuffer.position());
        //此方法很关键，源码是将pos赋值给lit，然后将pos置0
        //  limit = position;
        //  position = 0;
        //  mark = -1;
        //  return this;
        // 作用是进行读写切换
        // 比如 设置长度为5的intBuffer，cap=lit=5,
        // 当执行for循环后， pos = 5
        intBuffer.flip();
        System.out.println("````````````````````````````" );
        //cap: 5
        //lit: 5
        //pos: 0
        System.out.println("cap: " + intBuffer.capacity());
        System.out.println("lit: " + intBuffer.limit());
        System.out.println("pos: " + intBuffer.position());
        // public final boolean hasRemaining() {
        //        return position < limit;
        //    }
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
