package com.nexus.stickman.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class GameActivity extends Activity {
    private GameSurface surface;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        FrameLayout root = new FrameLayout(this);
        surface = new GameSurface(this);
        root.addView(surface);
        TextView notice = new TextView(this);
        notice.setText("游戏运行框架已启动\n原版关卡、战斗逻辑与资源仍待逐项还原");
        notice.setTextColor(Color.WHITE); notice.setTextSize(20);
        notice.setGravity(Gravity.CENTER);
        root.addView(notice);
        setContentView(root);
    }
    @Override protected void onPause() { super.onPause(); if (surface != null) surface.pause(); }
    @Override protected void onResume() { super.onResume(); if (surface != null) surface.resume(); }
    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { finish(); return true; }
        return surface != null && surface.onRemoteKey(keyCode) || super.onKeyDown(keyCode, event);
    }
}
