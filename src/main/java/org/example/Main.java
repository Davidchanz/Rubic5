package org.example;

import engine.graphics.*;
import engine.io.Input;
import engine.io.Window;
import engine.maths.Vector3f;
import engine.objects.Camera;
import engine.objects.GameObject;
import org.example.Rubic.Cube;
import org.example.Rubic.Rectangle;
import org.example.Rubic.Rubic;
import org.lwjgl.glfw.*;


import java.util.ArrayList;
import java.util.List;

// The window handle
    public class Main implements Runnable {
        public Thread game;
        public Window window;
        public Renderer renderer;
        public Shader shader;
        public final int WIDTH = 1200, HEIGHT = 900;

    /*public Mesh mesh = new Mesh(new Vertex[] {
            //Back face
            new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(1,1,0), new Material("/color/yelow.png")),
            new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(1,1,0), new Material("/color/yelow.png")),
            new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(1,1,0), new Material("/color/yelow.png")),
            new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(1,1,0), new Material("/color/yelow.png")),

    }, new int[] {
            //Back face
            0, 1, 2,
            2, 3, 0,
    }, new Material("/textures/1.png"));*/

        /*public Mesh mesh = new Mesh(new Vertex[] {
                //Back face
                new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(1,0,0), new Material("/color/red.png")),
                new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(1,0,0), new Material("/color/red.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(1,0,0), new Material("/color/red.png")),
                new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(1,0,0), new Material("/color/red.png")),

                //Front face
                new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(0,1,0), new Material("/color/blue.png")),
                new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(0,1,0), new Material("/color/blue.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(0,1,0), new Material("/color/blue.png")),
                new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(0,1,0), new Material("/color/blue.png")),

                //Right face
                new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(0,0,1), new Material("/color/green.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(0,0,1), new Material("/color/green.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(0,0,1), new Material("/color/green.png")),
                new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(0,0,1), new Material("/color/green.png")),

                //Left face
                new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(1,1,0), new Material("/color/orange.png")),
                new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(1,1,0), new Material("/color/orange.png")),
                new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(1,1,0), new Material("/color/orange.png")),
                new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(1,1,0), new Material("/color/orange.png")),

                //Top face
                new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(0,1,1), new Material("/color/white.png")),
                new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(0,1,1), new Material("/color/white.png")),
                new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(0,1,1), new Material("/color/white.png")),
                new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(0,1,1), new Material("/color/white.png")),

                //Bottom face
                new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(0.0f, 0.0f), new Vector3f(1,0,1), new Material("/color/yelow.png")),
                new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f), new Vector3f(1,0,1), new Material("/color/yelow.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f), new Vector3f(1,0,1), new Material("/color/yelow.png")),
                new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 0.0f), new Vector3f(1,0,1), new Material("/color/yelow.png")),
        }, new int[] {
                //Back face
                0, 1, 3,
                3, 1, 2,

                //Front face
                4, 5, 7,
                7, 5, 6,

                //Right face
                8, 9, 11,
                11, 9, 10,

                //Left face
                12, 13, 15,
                15, 13, 14,

                //Top face
                16, 17, 19,
                19, 17, 18,

                //Bottom face
                20, 21, 23,
                23, 21, 22
        }, new Material("/textures/bricks.png"));*/

        public List<GameObject> gameObjects;

    //public GameObject object = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh);

        public Camera camera = new Camera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0));
        public ArrayList<ShapeObject> ob = new ArrayList<>();
        Rubic rubic;

        public void start() {
            game = new Thread(this, "game");
            game.start();
        }

        public void init() {
            window = new Window(WIDTH, HEIGHT, "Game");
            shader = new Shader("/shaders/mainVertex.glsl", "/shaders/mainFragment.glsl");
            renderer = new Renderer(window, shader);
            window.setBackgroundColor(0f, 0f, 0f);
            window.create();
            //mesh.create();
            shader.create();

            gameObjects = new ArrayList<>();

            int rubic_size = 1;
            int interval = 1;
            for (int o = 0; o < rubic_size; ++o) {
                for (int k = 0; k < rubic_size; ++k) {
                    for (int l = 0; l < rubic_size; ++l) {

                        //gameObjects.add(new GameObject(new Vector3f(o * interval, k * interval, l * interval), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh));

                    }
                }
            }
           /* Rectangle s1 = new Rectangle(new Vector3f(0,0,0), new Vector3f(0,0,0));
            Rectangle s2 = new Rectangle(new Vector3f(1,0,0), new Vector3f(0,0,0));
            Rectangle s3 = new Rectangle(new Vector3f(0,1,0), new Vector3f(0,0,0));

            ob.add(s1);
            ob.add(s2);
            ob.add(s3);*/
            /*Cube cube1 = new Cube("cube", 1);
            Cube cube2 = new Cube("cube", 1);
            cube2.move(new Vector3f(2f,0,0));*/
            rubic = new Rubic(2, 0,0,0);
            ob.addAll(rubic.get());
            //System.out.println(rubic.center);
            /*ob.add(cube1);
            ob.add(cube2);
            System.out.println(cube2.getCenter());*/

        }

        public void run() {
            init();
            while (!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
                update();
                render();
                if (Input.isKeyDown(GLFW.GLFW_KEY_F11)) window.setFullscreen(!window.isFullscreen());
            }
            close();
        }

        private void update() {
            window.update();
            camera.update(/*rubic.get().get(0).body.get(0)*/);
            rubic.update();
            //if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("X: " + Input.getScrollX() + ", Y: " + Input.getScrollY());
        }

        private void render() {
            /*for (var it: gameObjects) {
                it.setRotation(new Vector3f(0,0,1));
                renderer.renderMesh(it, camera);
            }*/
            for (var o: ob) {
                for (var g: o.body) {
                    //g.setRotation(new Vector3f(0, 0, 1));
                    renderer.renderMesh(g, camera);
                }
            }
            //renderer.renderMesh(object, camera);
            window.swapBuffers();
        }

        private void close() {
            window.destroy();
            for (var o: ob) {
                for (var g: o.body) {
                    //g.setRotation(new Vector3f(0, 0, 1));
                    g.getMesh().destroy();
                }
            }
            //mesh.destroy();
            shader.destroy();
        }

        public static void main(String[] args) {
            new Main().start();
        }
}