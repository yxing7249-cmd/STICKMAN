package com.nexus.stickman;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nexus.stickman.game.GameActivity;

public class MainActivity extends Activity {
    private Button offline, online;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 24, 48, 24);
        root.setBackgroundColor(Color.rgb(18, 20, 31));
        TextView title = new TextView(this);
        title.setText("NEXUS STICKMAN TRIBE");
        title.setTextColor(Color.WHITE); title.setTextSize(30);
        title.setGravity(Gravity.CENTER); root.addView(title);
        TextView subtitle = new TextView(this);
        subtitle.setText("1:1 reconstruction workspace · Android TV");
        subtitle.setTextColor(Color.LTGRAY); subtitle.setTextSize(15);
        subtitle.setGravity(Gravity.CENTER); root.addView(subtitle);
        offline = makeButton("单机模式");
        online = makeButton("联网模式（服务器接入待完成）");
        root.addView(offline); root.addView(online);
        offline.setOnClickListener(v -> launch(false));
        online.setOnClickListener(v -> Toast.makeText(this,
            "联网接口尚未配置；当前不会连接原游戏服务器。", Toast.LENGTH_LONG).show());
        setContentView(root);
        offline.requestFocus();
    }
    private Button makeButton(String label) {
        Button b = new Button(this); b.setText(label); b.setTextSize(18);
        b.setFocusable(true); b.setPadding(24, 12, 24, 12);
        return b;
    }
    private void launch(boolean onlineMode) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("online", onlineMode); startActivity(i);
    }
    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { return true; }
        return super.onKeyDown(keyCode, event);
    }
}
