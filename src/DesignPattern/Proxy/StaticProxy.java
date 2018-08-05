package DesignPattern.Proxy;

/**
 * ��̬�����ܽ�: 1.���������ڲ��޸�Ŀ�����Ĺ���ǰ����,��Ŀ�깦����չ. 
 * 2.ȱ��:
 * ��Ϊ���������Ҫ��Ŀ�����ʵ��һ���Ľӿ�,���Ի��кܶ������,��̫��.ͬʱ,һ���ӿ����ӷ���,Ŀ�������������Ҫά��.
 * ��ν����̬�����е�ȱ����?���ǿ���ʹ�ö�̬����ʽ
 */
public class StaticProxy {
	public static void main(String[] args) {
		// Ŀ�����
		UserDao target = new UserDao();

		// �������,��Ŀ����󴫸��������,���������ϵ
		UserDaoProxy proxy = new UserDaoProxy(target);

		proxy.save();// ִ�е��Ǵ���ķ���
	}
}