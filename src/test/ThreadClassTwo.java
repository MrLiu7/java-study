package test;//���ڴ����ʵ�ִ���

/********** Begin **********/
public class ThreadClassTwo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
    }

}


/********** End **********/
