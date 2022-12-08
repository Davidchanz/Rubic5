package org.example.Rubic;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Vector2f;
import engine.maths.Vector3f;
import engine.objects.GameObject;
import org.example.ShapeObject;

import java.awt.*;

public class Rectangle extends GameObject {
    public Rectangle(Vector3f P0, Vector3f P1, Vector3f P2, Vector3f P3, Vector3f position, Vector3f normal, Color color){
        Vector3f c = new Vector3f(color.getRed()/255,color.getGreen()/255,color.getBlue()/255);
        Mesh mesh = new Mesh(new Vertex[] {
                //Back face
                new Vertex(P0, new Vector2f(0.0f, 0.0f), c),
                new Vertex(P1, new Vector2f(0.0f, 1.0f), c),
                new Vertex(P2, new Vector2f(1.0f, 1.0f), c),
                new Vertex(P3, new Vector2f(1.0f, 0.0f), c),

        }, new int[] {
                //Back face
                0, 1, 2,
                2, 3, 0,
        }, new Material("/textures/1.png"));

        build(position, new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), normal, mesh);

        float sumX=0;
        float sumY=0;
        float sumZ=0;

        sumX+= P0.getX() + P1.getX() + P2.getX() + P3.getX() /*+ getPosition().getX()*/;//compute sum centers X
        sumY+= P0.getY() + P1.getY() + P2.getY() + P3.getY() /*+ getPosition().getY()*/;;//compute sum centers Y
        sumZ+= P0.getZ() + P1.getZ() + P2.getZ() + P3.getZ() /*+ getPosition().getZ()*/;;//compute sum centers Z

         setCenter(new Vector3f(sumX/4, sumY/4, sumZ/4));//ini center
        /*add(new GameObject(new Vector3f(1,0,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));
        add(new GameObject(new Vector3f(-1,0,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));

        add(new GameObject(new Vector3f(0,1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));
        add(new GameObject(new Vector3f(1,1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));
        add(new GameObject(new Vector3f(-1,1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));

        add(new GameObject(new Vector3f(0,-1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));
        add(new GameObject(new Vector3f(1,-1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));
        add(new GameObject(new Vector3f(-1,-1,0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));*/

    }
}
