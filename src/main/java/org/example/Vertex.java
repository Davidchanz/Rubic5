package org.example;

import org.UnityMath.Vector3;

public class Vertex {
    private Vector3 position;

    Vertex(Vector3 pos){
        this.position = pos;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
}
