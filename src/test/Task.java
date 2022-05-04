package test;

public class Task {
    public static void main(String[] args) throws Exception {
        /********* Begin *********/
        //在这里创建线程， 开启线程
        String[] str = {"AA", "BB", "CC"};
        MyThread[] myThread = new MyThread[3];
        for (int i = 0; i < 3; i++) {
            myThread[i] = new MyThread(str[i]);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                myThread[j].start();
                myThread[j].sleep(100);
            }
        }

        /********* End *********/
    }
}

class MyThread extends Thread {
    /********* Begin *********/


    String threadName;

    public MyThread(String name){
        threadName = name;
    }

    public void run() {
        int count = 5;
        while (count > 0) {
            System.out.println("Java Thread" + this.threadName);
            count--;
        }
    }

    /********* End *********/
}