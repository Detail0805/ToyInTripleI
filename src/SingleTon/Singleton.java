package SingleTon;

public class Singleton {
	 private static Singleton instance;

	    private Singleton(){
	        // �o�̭��]�ܤF�hcode�A�إߪ���ݭn��O�ܦh�귽
	    }

	    public static Singleton getInstance(){
	        // �Ĥ@���Q�I�s���ɭԦA�إߪ���
	        if(instance == null){
	        	synchronized(Singleton.class){
	        		
	            instance = new Singleton();
	            }
	        } 
	        return instance;
	    }
}
