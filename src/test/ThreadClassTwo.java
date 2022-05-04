package test;//请在此添加实现代码

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
