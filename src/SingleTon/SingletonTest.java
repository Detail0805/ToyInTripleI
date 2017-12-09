package SingleTon;

public class SingletonTest extends Thread {
    String myId;
    public SingletonTest(String id) {
        myId = id;
    }

    // ��������檺�ɭԴN�h�I�sSingleton.getInstance()
    public void run() {
    	Singleton singleton = Singleton.getInstance();
        if(singleton != null){
            // ��hashCode�P�_�e��⦸���쪺Singleton����O�_���P�@��
            System.out.println(myId+"���� Singleton:" + singleton.hashCode());               
        }
    }

    public static void main(String[] argv) {
        /*
        // ���������ɭԡAs1�Ps2�T�ꬰ�P�@�Ӫ���
        Singleton s1  =  Singleton.getInstance();
        Singleton s2  =  Singleton.getInstance();
        System.out.println("s1:"+s1.hashCode() + " s2:" + s2.hashCode());
        System.out.println();
        */

        // ��Ӱ�����P�ɰ���
        Thread t1 = new SingletonTest("�����T1"); // ����Thread����
        Thread t2 = new SingletonTest("�����T2"); // ����Thread����
        t1.start(); // �}�l����t1.run()
        t2.start();
    }
}
