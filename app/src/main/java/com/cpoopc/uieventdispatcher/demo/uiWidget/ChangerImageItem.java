package com.cpoopc.uieventdispatcher.demo.uiWidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.cpoopc.uieventdispatcher.EventSource;
import com.cpoopc.uieventdispatcher.IUIEvent;
import com.cpoopc.uieventdispatcher.IUIEventDispatcher;
import com.cpoopc.uieventdispatcher.R;
import com.cpoopc.uieventdispatcher.baseEvent.Onclick;

/**
 * @author cpoopc
 * @date 2016/3/11
 * @time 15:07
 * @description
 */
public class ChangerImageItem implements IUIEventDispatcher, View.OnClickListener {

    /**
     * 此UI的特定事件
     */
    public static class OnImageChange implements IUIEvent {

    }

    private IUIEventDispatcher mEventDispatcher;

    public void setEventDispatcher(IUIEventDispatcher eventDispatcher) {
        mEventDispatcher = eventDispatcher;
    }

    private View mRootView;
    private ImageView mImageView;
    private EventButton mButton;

    public ChangerImageItem(Context context) {
        mRootView = LayoutInflater.from(context).inflate(R.layout.view_test, null);
        mImageView = (ImageView) mRootView.findViewById(R.id.imageView);
        mButton = (EventButton) mRootView.findViewById(R.id.button);
        mButton.setEventDispatcher(this);
    }

    public View getRootView() {
        return mRootView;
    }

    @Override
    public boolean dispatchUIEvent(EventSource source, IUIEvent uiEvent) {
        if (source.getSrcNearest() == mButton) {
            if (uiEvent.getClass() == Onclick.class) {
                android.util.Log.d("cp:", "on button click");
//                处理事件,向外部抛出处理后的新事件
                changeImage();
            }
        } else if (mEventDispatcher != null) {
            return mEventDispatcher.dispatchUIEvent(source.dispatch(this), uiEvent);
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if (v == mImageView) {
//                直接向外部抛出事件
            changeImage();
        }
    }

    private void changeImage() {
        dispatchUIEvent(EventSource.gen(mImageView), new OnImageChange());
    }
}
