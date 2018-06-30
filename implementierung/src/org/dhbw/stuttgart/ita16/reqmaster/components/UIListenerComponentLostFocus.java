package org.dhbw.stuttgart.ita16.reqmaster.components;

import java.awt.*;

@FunctionalInterface
public interface UIListenerComponentLostFocus {

    void lostFocus(Component lostFocus, Component gotFocus);

}
