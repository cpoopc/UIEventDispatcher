package com.cpoopc.uieventdispatcher.demo.uiWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.cpoopc.uieventdispatcher.EventSource;
import com.cpoopc.uieventdispatcher.IUIEventDispatcher;
import com.cpoopc.uieventdispatcher.baseEvent.Onclick;

/**
 *
 * @author cpoopc
 * @date 2016/3/11
 * @time 15:36
 * @description
 */
public class EventButton extends Button {

    private IUIEventDispatcher mEventDispatcher;

    public EventButton(Context context) {
        super(context);
        init();
    }

    public EventButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EventButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEventDispatcher != null) {
                    mEventDispatcher.dispatchUIEvent(EventSource.gen(EventButton.this), new Onclick());
                }
            }
        });
    }

    public void setEventDispatcher(IUIEventDispatcher eventDispatcher) {
        mEventDispatcher = eventDispatcher;
    }
}
