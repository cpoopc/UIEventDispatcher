package com.cpoopc.uieventdispatcher.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.cpoopc.uieventdispatcher.EventSource;
import com.cpoopc.uieventdispatcher.IUIEvent;
import com.cpoopc.uieventdispatcher.IUIEventDispatcher;
import com.cpoopc.uieventdispatcher.R;
import com.cpoopc.uieventdispatcher.demo.uiWidget.ChangerImageItem;

public class MainActivity extends AppCompatActivity implements IUIEventDispatcher {

    private ChangerImageItem mChangerImageItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        mChangerImageItem = new ChangerImageItem(this);
        mChangerImageItem.setEventDispatcher(this);
        container.addView(mChangerImageItem.getRootView());

    }

    @Override
    public boolean dispatchUIEvent(EventSource source, IUIEvent uiEvent) {
        if (source.getSrcNearest() == mChangerImageItem) {
            // 处理ChangerImageItem抛出的事件
            android.util.Log.d("cp:", "ChangerImageItem " + uiEvent);
        }
        android.util.Log.d("cp:", "dispatchUIEvent " + uiEvent);
        return false;
    }
}
