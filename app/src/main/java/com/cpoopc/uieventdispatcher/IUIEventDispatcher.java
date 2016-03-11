package com.cpoopc.uieventdispatcher;

/**
 * UI事件分发
 * @author cpoopc
 * @date 2016/3/11
 * @time 14:44
 * @description
 */
public interface IUIEventDispatcher {

    boolean dispatchUIEvent(EventSource source, IUIEvent uiEvent);

}
