package NIO.ibmdw.nio;// $Id$

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MultiPortEcho
{
  private int ports[];
  private ByteBuffer echoBuffer = ByteBuffer.allocate( 1024 );

  public MultiPortEcho( int ports[] ) throws IOException {
    this.ports = ports;

    go();
  }

  private void go() throws IOException {
    // 创建一个 selector 实例
    Selector selector = Selector.open();

    // Open a listener on each port, and register each one
    // with the selector
    for (int i=0; i<ports.length; ++i) {
    	// 注册一个channel
      ServerSocketChannel ssc = ServerSocketChannel.open();
      ssc.configureBlocking( false );
      ServerSocket ss = ssc.socket();
      // 绑定一个端口 
      InetSocketAddress address = new InetSocketAddress( ports[i] );
      ss.bind( address );
     // 注册一个事件 监听自己感兴趣事件
      SelectionKey key = ssc.register( selector, SelectionKey.OP_ACCEPT );

      System.out.println( "Going to listen on "+ports[i] );
    }
    // 重复执行 
    while (true) {
      int num = selector.select();
      // 调用一种 select 方法
      Set selectedKeys = selector.selectedKeys();
      Iterator it = selectedKeys.iterator();

      while (it.hasNext()) {
        SelectionKey key = (SelectionKey)it.next();

        if ((key.readyOps() & SelectionKey.OP_ACCEPT)
          == SelectionKey.OP_ACCEPT) {
          // Accept the new connection
          ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
          SocketChannel sc = ssc.accept();
          sc.configureBlocking( false );

          // Add the new connection to the selector
          SelectionKey newKey = sc.register( selector, SelectionKey.OP_READ );
          it.remove();

          System.out.println( "Got connection from "+sc );
        } else if ((key.readyOps() & SelectionKey.OP_READ)
          == SelectionKey.OP_READ) {
          // Read the data
          SocketChannel sc = (SocketChannel)key.channel();

          // Echo data
          int bytesEchoed = 0;
          while (true) {
            echoBuffer.clear();

            int r = sc.read( echoBuffer );

            if (r<=0) {
              break;
            }

            echoBuffer.flip();

            sc.write( echoBuffer );
            bytesEchoed += r;
          }

          System.out.println( "Echoed "+bytesEchoed+" from "+sc );
   //
          it.remove();
        }

      }

//System.out.println( "going to clear" );
//      selectedKeys.clear();
//System.out.println( "cleared" );
    }
  }

  static public void main( String args[] ) throws Exception {
    if (args.length<=0) {
      System.err.println( "Usage: java MultiPortEcho port [port port ...]" );
      System.exit( 1 );
    }

    int ports[] = new int[args.length];

    for (int i=0; i<args.length; ++i) {
      ports[i] = Integer.parseInt( args[i] );
    }

    new MultiPortEcho( ports );
  }
}
