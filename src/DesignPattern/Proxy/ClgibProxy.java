package DesignPattern.Proxy;
/**
 * 测试类
 */
public class ClgibProxy {

	 public static void main(String[] args){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new CProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}