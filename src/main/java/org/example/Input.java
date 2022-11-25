package org.example;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import static org.lwjgl.glfw.GLFW.*;

public class Input {
    private GLFWKeyCallback keyCallback;
    private GLFWMouseButtonCallback mouseButtonCallback;
    private GLFWCursorPosCallback cursorPosCallback;
    private double mouseX;
    private double mouseY;
    private boolean[] keys = new boolean[GLFW_KEY_LAST];
    private boolean[] buttons = new boolean[GLFW_MOUSE_BUTTON_LAST];

    Input() {
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                keys[key] = (action != GLFW_RELEASE);
            }
        };
        mouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action != GLFW_RELEASE);
            }
        };
        cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                mouseX = xpos;
                mouseY = ypos;
            }
        };
    }
    public boolean isKeyDown(int key){
        return keys[key];
    }
    public void destroy(){
        keyCallback.free(); 
        mouseButtonCallback.free();
        cursorPosCallback.free();
    }

    public GLFWKeyCallback getKeyCallback() {
        return keyCallback;
    }

    public GLFWMouseButtonCallback getMouseButtonCallback() {
        return mouseButtonCallback;
    }

    public GLFWCursorPosCallback getCursorPosCallback() {
        return cursorPosCallback;
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }
}
