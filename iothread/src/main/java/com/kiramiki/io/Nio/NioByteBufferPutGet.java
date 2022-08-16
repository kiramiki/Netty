package com.kiramiki.io.Nio;

import java.nio.ByteBuffer;

/**
 * @ Author ：zl.
 * @ Date ：Created in 15:24 2022/8/12
 * @ Description ：
 */
public class NioByteBufferPutGet {

    /**
     * ByteBuffer 支持类型化的 put 和 get，put 放入的是什么数据类型，get 就应该使用相应的数据类型来取出，否则可能有 BufferUnderflowException 异常。【举例说明】
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        // 顺序写入
        buffer.putInt(643);
        buffer.putLong(9);
        buffer.putChar('脏');
        buffer.putShort((short)4);

        buffer.flip();

        System.out.println();
        // 顺序读取
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        // 不按照顺序读取可能报错
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}
