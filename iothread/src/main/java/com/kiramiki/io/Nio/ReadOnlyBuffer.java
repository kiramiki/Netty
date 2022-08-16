package com.kiramiki.io.Nio;

import java.nio.ByteBuffer;

/**
 * @ Author ：zl.
 * @ Date ：Created in 15:23 2022/8/12
 * @ Description ：
 */
public class ReadOnlyBuffer {

    //可以将一个普通 Buffer 转成只读 Buffer【举例说明】
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0 ; i < 64 ; i++){
            buffer.put((byte) i);
        }

        buffer.flip();

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        while(readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 100);
    }
}
