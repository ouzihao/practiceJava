package case_practice.传统IO与NIO在网络传输中的差异;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestClient {

    public static void main(String[] args) throws InterruptedException {

        int clientCount = 10000;
        ExecutorService executorServiceIO = Executors.newFixedThreadPool(10);
        ExecutorService executorServiceNIO = Executors.newFixedThreadPool(10);

        Runnable ioClient = () -> {
            try {
                Socket socket = new Socket("127.0.0.1", 9001);

                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                out.write("Hello_Rami_IO!!!!".getBytes());
                byte[] buffer = new byte[1024];
                in.read(buffer);
                in.close();
                out.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Runnable NIOClient = () -> {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress("127.0.0.1", 9002));
                ByteBuffer buffer = ByteBuffer.wrap("Hello_Rami_NIO!!!!".getBytes());
                socketChannel.write(buffer);
                buffer.clear();
                socketChannel.read(buffer);
                socketChannel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < clientCount; i++) {
            executorServiceIO.execute(ioClient);
        }
        executorServiceIO.shutdown();
        executorServiceIO.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.currentTimeMillis();
        System.out.println("传统 IO 服务器处理 " + clientCount + " 个客户端耗时: " + (endTime - startTime) + "ms");

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < clientCount; i++) {
            executorServiceNIO.execute(NIOClient);
        }
        executorServiceNIO.shutdown();
        executorServiceNIO.awaitTermination(1, TimeUnit.MINUTES);
        long endTime1 = System.currentTimeMillis();
        System.out.println("NIO 服务器处理 " + clientCount + " 个客户端耗时: " + (endTime1 - startTime1) + "ms");





    }
}
