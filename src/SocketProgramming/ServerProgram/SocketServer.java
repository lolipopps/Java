package SocketProgramming.ServerProgram;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
  public static void main(String[] args) throws Exception {
    // 监听指定的端口
    int port = 55533;
    ServerSocket server = new ServerSocket(port);
    
    // server将一直等待连接的到来
    System.out.println("server将一直等待连接的到来");
    Socket socket = server.accept();
    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
    InputStream inputStream = socket.getInputStream();
    byte[] bytes = new byte[1024];
    int len;
    StringBuilder sb = new StringBuilder();
    //只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
    while ((len = inputStream.read(bytes)) != -1) {  // 接受客户端数据
      // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
      sb.append(new String(bytes, 0, len, "UTF-8"));
    }
    System.out.println("get message from client: " + sb);

    OutputStream outputStream = socket.getOutputStream();
    outputStream.write("Hello Client,I get the message.".getBytes("UTF-8")); // 把数据返还给客户端

    inputStream.close();
    outputStream.close();
    socket.close();
    server.close();
  }
}