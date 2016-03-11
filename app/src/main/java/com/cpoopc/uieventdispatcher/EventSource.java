package com.cpoopc.uieventdispatcher;

import android.view.View;

/**
 * 事件源
 * @author cpoopc
 * @date 2016/3/11
 * @time 15:04
 * @description
 */
public class EventSource {

    /**
     * 距离最近的源
     */
    private Object srcNearest;

    /**
     * 产生事件的根源
     */
    private View srcRaw;

    private EventSource(Object srcNearest, View srcRaw) {
        this.srcNearest = srcNearest;
        this.srcRaw = srcRaw;
    }

    /**
     * 产生事件
     * @param ui
     * @return
     */
    public static EventSource gen(View ui) {
        return new EventSource(ui, ui);
    }

    /**
     * 分发事件,经手后将最近的源改为自己
     * @param dispatcher
     * @return
     */
    public EventSource dispatch(Object dispatcher) {
        this.srcNearest = dispatcher;
        return this;
    }

    public Object getSrcNearest() {
        return srcNearest;
    }

    public View getSrcRaw() {
        return srcRaw;
    }
}
