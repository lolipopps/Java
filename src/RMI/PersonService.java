package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import RMI.PersonEntity;;

//此为远程对象调用的接口，必须继承Remote类以及是 公有的
public interface PersonService extends Remote {
	// 一定要抛出 RemoteException异常 
    public List<PersonEntity> GetList() throws RemoteException;
}