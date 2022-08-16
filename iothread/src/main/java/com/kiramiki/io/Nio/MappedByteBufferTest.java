package com.kiramiki.io.Nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ Author ：kirmaiki.
 * @ Date ：Created in 16:09 2022/8/12
 * @ Description ：
 */
public class MappedByteBufferTest {

    //NIO 还提供了 MappedByteBuffer，可以让文件直接在内存（堆外的内存）中进行修改，
    // 而如何同步到文件由 NIO 来完成。【举例说明】
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");

        FileChannel fileChannel = randomAccessFile.getChannel();


         /**
         * 参数 1:FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数 2：0：可以直接修改的起始位置
         * 参数 3:5: 是映射到内存的大小（不是索引位置），即将 1.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-5
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0 ,5);

        mappedByteBuffer.put(0,(byte) 'H');
        mappedByteBuffer.put(3,(byte) '9');
        mappedByteBuffer.put(5,(byte) 'Y');//IndexOutOfBoundsException

        randomAccessFile.close();

        System.out.println("修改成功");
    }
}
