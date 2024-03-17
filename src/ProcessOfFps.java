public class ProcessOfFps implements Runnable {
    private int fps = 120;
    private int UPS = 120;
    Thread gameLoopThread;

    public ProcessOfFps(){
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    @Override
    public void run(){
        double timePerFrame = 1000000000.0 / fps;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                //put your statement in this part

                //

                /** DO NOT OMIT THESE TWO STATEMENT*/
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {//for Fps
                //put your statement in this part


                //

                /** DO NOT OMIT THESE TWO STATEMENT*/
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {//every 1 sec

            }
        }
    }
}