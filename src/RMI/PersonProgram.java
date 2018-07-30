package RMI;



import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/*
 * RMI 过程Java远程方法调用，即Java RMI,一种用于实现远程过程调用的应用程序编程接口。
 * 它使客户机上运行的程序可以调用远程服务器上的对象而不用了解具体的底层原理。远程方法调用特性使Java编程人员能够在网络环境中分布操作。
 * 远程过程调用最终的实现是 客户端调用想调用本地函数一样调用远程的方法服务。 参数等
 * 引入了客户存根和服务器骨架的概念 因为远程调用的过程是一样的把这些一样的固化
 * stub/skeleton   
 * stub 代表被客户端引用的远程对象,保存了远程对象的接口和方法列表
 * skeleton  服务端的skeleton 处理有关调用远程对象的所有细节并调用 skeleton 对象
 */
public class PersonProgram{

    public static void main(String[] args) {
        try {
            PersonService personService=new PersonServiceImpl();
            //注册通讯端口
            LocateRegistry.createRegistry(6600);
            //注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
            System.out.println("Service Start!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}