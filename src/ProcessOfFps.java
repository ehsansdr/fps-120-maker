import java.util.concurrent.ThreadPoolExecutor;

public class ProcessOfFps implements Runnable{
    Thread framePerSecThread;
    final int FPS_SET = 120;
    public ProcessOfFps() {

        startGameLoop();
    }
    private void startGameLoop() {
        framePerSecThread = new Thread(this);
        framePerSecThread.start();
    }

    @Override
    public void run() {//how thread would do and mange in this progeam

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {

            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

    }
}
