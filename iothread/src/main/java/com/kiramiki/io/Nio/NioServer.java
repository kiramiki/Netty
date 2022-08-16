package com.kiramiki.io.Nio;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @ Author ：kiramiki
 * @ Date ：Created in 9:15 2022/7/28
 * @ Description ：Nio
 */
public class NioServer {
    //BIO 以流的方式处理数据，而 NIO 以块的方式处理数据，块 I/O 的效率比流 I/O 高很多。
    //BIO 是阻塞的，NIO 则是非阻塞的。
    //BIO 基于字节流和字符流进行操作，而 NIO 基于 Channel（通道）和 Buffer（缓冲区）进行操作，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。Selector（选择器）用于监听多个通道的事件（比如：连接请求，数据到达等），因此使用单个线程就可以监听多个客户端通道。
    //Buffer和Channel之间的数据流向是双向的


    public static void main1(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zyw\\Desktop\\智慧物管\\收费标准\\2014\\2014年1级.pdf");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zyw\\Desktop\\智慧物管\\收费标准\\2014\\2014年1级.jpg");

        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();

        destCh.transferFrom(sourceCh,0,sourceCh.size());

        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();
    }


    public static void main(String[] args) {
        String declareNum = "SYSZ202008100021";
        String sub = declareNum.substring(12,declareNum.length());
        System.out.println(sub);
        int num = Integer.parseInt(sub);
        System.out.println(num);
        num++;
        sub = String.format("%04d",num);
        System.out.println(sub);
    }
}
