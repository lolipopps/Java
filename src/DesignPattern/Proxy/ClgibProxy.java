package DesignPattern.Proxy;
/**
 * ������
 */
public class ClgibProxy {

	 public static void main(String[] args){
        //Ŀ�����
        UserDao target = new UserDao();

        //�������
        UserDao proxy = (UserDao)new CProxyFactory(target).getProxyInstance();

        //ִ�д������ķ���
        proxy.save();
    }
}