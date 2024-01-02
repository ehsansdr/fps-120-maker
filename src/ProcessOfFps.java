public class ProcessOfFps implements Runnable{
    Thread framePerSecThread;
    final int FPS_SET = 120;
    double timePerFrameByNanoSec = 1000000000.0 / FPS_SET;// 1_000_000_000.0 ns = 1 sec
    public ProcessOfFps() {

        startGameLoop();
    }
    private void startGameLoop() {
        framePerSecThread = new Thread(this);
        framePerSecThread.start();
    }

    @Override
    public void run() {//how thread would do and mange in this progeam

        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;

        //these variables have control the IFs in while(true) loop and manage the loop duration times
        //it is not actually and basically every 1 or 5 or ... sec
        //it defines it work that how we use
        long lastCheckOn_1_Sec = System.currentTimeMillis();
        long lastCheckOn_5_Sec = System.currentTimeMillis();

        while (true) {

            now = System.nanoTime();
            if (now - lastFrame >= timePerFrameByNanoSec) {//this "if" execute 120 per 1 sec based on this ("content")
                /**
                you can put your statement with you want to execute every *** time (base on ( >= ***) in if's condition)
                 */

                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheckOn_1_Sec >= 1000) {//this "if" execute every 1 sec based on this ("content")
                System.out.println("FPS: " + frames);
                /**
                you can put your statement with you want to execute like upper statement
                 every x time (base on ( >= ***) in if's condition)
                 */


                lastCheckOn_1_Sec = System.currentTimeMillis();
                frames = 0;
            }


            if (System.currentTimeMillis() - lastCheckOn_5_Sec >= 5000) {//this "if" execute every 5 sec based on this ("content")
                /**
                you can put your statement with you want to execute every *** time (base on ( >= ***) in if's condition)
                 */
                lastCheckOn_5_Sec = System.currentTimeMillis();
                System.out.println("5 sec passed ");
            }
        }

    }
}
