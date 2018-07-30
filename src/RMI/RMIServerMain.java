package RMI;

import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RMI服务器的简单实现。 在命令行上设置以下属性： -Djava.rmi.server.useCodebaseOnly = false
 * -Djava.rmi.server.codebase = file：/ path / to / compiled / class / files / <
 * b >注意：请确认您有跟踪/在COADBASE路径</ b>
 *
 */
public class RMIServerMain {

	public static void main(String[] args) {
		// 首先，创建将执行所请求功能的真实对象。
		PrintingInterfaceImpl implementation = new PrintingInterfaceImpl();

		try {
			// Export the object.
			PrintingInterface stub = (PrintingInterface) UnicastRemoteObject.exportObject(implementation, 0);
			Registry registry = LocateRegistry.getRegistry();
			// 我不知道为什么要重新绑定
			// 但是，这确实设置了您需要使用的字符串以查找远程类。
			registry.rebind("RMI-EchoMessage", stub);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		System.out.println("Bound!");
		System.out.println("Server will wait forever for messages.");
	}
}