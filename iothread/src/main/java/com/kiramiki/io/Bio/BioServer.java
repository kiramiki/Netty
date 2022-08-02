package com.kiramiki.io.Bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author ：kiramiki.
 * @ Date ：Created in 15:00 2022/7/27
 * @ Description ：bio
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        //线程池机制
        //思路
        //1. 创建一个线程池
        //2. 如果有客户端连接，就创建一个线程，与之通讯(单独写一个方法)
        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务已启动~~~~~~~~");
        while (true){
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字" + Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待链接");
            //会阻塞在accept()
            final Socket socket = serverSocket.accept();
            System.out.println("链接到一个客户端");
            //就创建一个线程，与之通讯(单独写一个方法)
            newCacheThreadPool.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket){
        try {
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true){
                System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字" + Thread.currentThread().getName());
                System.out.println("read~~~~~~~");
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(new String(bytes,0,read));
                }else{
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭链接~~~~~~~~");
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
