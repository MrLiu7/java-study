package test;

//请在此添加实现代码

/********** Begin **********/
public class ThreadClassOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) System.out.print(i + " ");
        }
    }
}


/********** End **********/
