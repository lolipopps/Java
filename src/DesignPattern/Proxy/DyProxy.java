package DesignPattern.Proxy;

/**
 ��̬����
��̬�����������ص�:
1.�������,����Ҫʵ�ֽӿ�
2.������������,������JDK��API,��̬�����ڴ��й����������(��Ҫ����ָ�������������/Ŀ�����ʵ�ֵĽӿڵ�����)
3.��̬����Ҳ����:JDK����,�ӿڴ���

JDK�����ɴ�������API
���������ڰ�:java.lang.reflect.Proxy
JDKʵ�ִ���ֻ��Ҫʹ��newProxyInstance����,���Ǹ÷�����Ҫ������������,������д����:

static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
ע��÷�������Proxy�����Ǿ�̬����,�ҽ��յ�������������Ϊ:

ClassLoader loader,:ָ����ǰĿ�����ʹ���������,��ȡ�������ķ����ǹ̶���
Class<?>[] interfaces,:Ŀ�����ʵ�ֵĽӿڵ�����,ʹ�÷��ͷ�ʽȷ������
InvocationHandler h:�¼�����,ִ��Ŀ�����ķ���ʱ,�ᴥ���¼��������ķ���,��ѵ�ǰִ��Ŀ�����ķ�����Ϊ��������
 */
public class DyProxy {
    public static void main(String[] args) {
        // Ŀ�����
        IUserDao target = new UserDao();
        // ��ԭʼ������ class cn.itcast.b_dynamic.UserDao��
        System.out.println(target.getClass());

        // ��Ŀ����󣬴����������
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   �ڴ��ж�̬���ɵĴ������
        System.out.println(proxy.getClass());

        // ִ�з���   ���������
        proxy.save();
    }
}
