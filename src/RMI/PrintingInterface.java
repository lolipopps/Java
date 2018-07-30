package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 一个简单的接口实现了宣传打印的方法
 * 
 */
public interface PrintingInterface extends Remote {
    
    /**
     * 远程打印服务
     * 
     * @param str
     * @return
     * @throws RemoteException 
     */
    public int echoMessage( String str ) throws RemoteException;
}
