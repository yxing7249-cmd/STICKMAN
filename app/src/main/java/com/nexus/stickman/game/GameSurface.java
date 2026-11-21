package com.nexus.stickman.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/** Lightweight 2D rendering loop placeholder; original gameplay must be ported from verified source. */
public class GameSurface extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Thread thread;
    private volatile boolean running;
    private volatile int frame;
    public GameSurface(Context context) { super(context); getHolder().addCallback(this); setFocusable(true); }
    @Override public void surfaceCreated(SurfaceHolder holder) { resume(); }
    @Override public void surfaceChanged(SurfaceHolder h, int f, int w, int height) {}
    @Override public void surfaceDestroyed(SurfaceHolder holder) { pause(); }
    public void resume() { if (thread == null || !thread.isAlive()) { running = true; thread = new Thread(this, "NexusGameLoop"); thread.start(); } }
    public void pause() { running = false; if (thread != null) { try { thread.join(300); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); } thread = null; } }
    @Override public void run() {
        while (running) {
            if (!getHolder().getSurface().isValid()) continue;
            Canvas c = null;
            try {
                c = getHolder().lockCanvas();
                if (c != null) {
                    c.drawRGB(24, 28, 42);
                    paint.setColor(0xFFFFD45C);
                    float x = c.getWidth() * 0.5f + (float)Math.sin(frame * 0.04) * 90f;
                    c.drawCircle(x, c.getHeight() * 0.58f, 18, paint);
                    paint.setColor(0xFFFFFFFF);
                    paint.setTextSize(22);
                    c.drawText("NEXUS · gameplay renderer placeholder", 28, 42, paint);
                    frame++;
                }
            } finally { if (c != null) getHolder().unlockCanvasAndPost(c); }
            try { Thread.sleep(33); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        }
    }
    public boolean onRemoteKey(int keyCode) { return keyCode == android.view.KeyEvent.KEYCODE_DPAD_CENTER; }
}
