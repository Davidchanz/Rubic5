package org.example.Rubic;

import engine.io.Input;
import engine.maths.Vector3f;
import org.example.ShapeObject;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rubic {
    public int rubic_size;
    public Cube[][][] cube;
    public List<Cube> body;
    public int angX;
    public int angY;
    public int angZ;
    public Vector3f center;
    public Vector3f position;
    public Rubic(){
        this.body = new ArrayList<>();
        this.angX = 0;
        this.angY = 0;
        this.angZ = 0;
        this.center = new Vector3f(0,0, 0);
        this.position = new Vector3f(0,0, 0);
    }

    public Rubic(int size, float x, float y, float z){
        this();
        this.rubic_size = size;
        float interval = 1f;
        cube = new Cube[rubic_size][rubic_size][rubic_size];
        for (int o = 0; o < rubic_size; ++o) {
            for (int k = 0; k < rubic_size; ++k) {
                for (int l = 0; l < rubic_size; ++l) {
                    Cube cube = new Cube("(" + o + "," + k + "," + l + ")", 1, new Vector3f(o * interval, k * interval, l * interval));
                    if(o == 0 && k == 0 && l == 0){
                        //cube.move(new Vector3f(o * interval, k * interval, l * interval));
                        //cube.changeColor(new Vector3f(1,0,1));
                        //cube.move(new Vector3f(-200, -200, 200)); //TODO fix center ShapesObject3D, fix rotate, do rotate any peace of complex object
                    }else {
                        //if(o != 1 || ((k != 0 || k != 2) || (l != 0 || l != 2))) {
                        //cube.move(new Vector3f(o * interval, k * interval, l * interval));
                        //cube.move(new Vector3f(-200, -200, 200)); //TODO fix center ShapesObject3D, fix rotate, do rotate any peace of complex object
                        //}
                    }
                    add(cube);
                    //System.out.println(cube.getCenter());
                    this.cube[o][k][l] = cube;
                }
            }
        }
        move(new Vector3f(x,y,z));
    }
    public void add(ShapeObject o){
        body.add((Cube) o);
        computeCenter();
    }
    private void computeCenter(){
        //System.out.println(center);
        float sumX=0;
        float sumY=0;
        float sumZ=0;
        for(var i: body){
            sumX+= i.getCenter().getX() + i.getPosition().getX();
            sumY+= i.getCenter().getY() + i.getPosition().getY();
            sumZ+= i.getCenter().getZ() + i.getPosition().getZ();
        }
        this.center = new Vector3f(sumX/this.body.size(), sumY/this.body.size(), sumZ/this.body.size());//todo compute
        //this.center.add(this.position);

        /*for(var i: this.body){
            i.setCenter(new Vector3f(center));//ini shape parent
        }*/
    }
    public ArrayList<ShapeObject> get(){
        return new ArrayList<>(body);
    }
    /*public void setAngleX(int ang){
        for(var i: body){
            i.angX = ang;
        }
    }
    public void setAngleY(int ang){
        for(var i: body){
            i.angY = ang;
        }
    }
    public void setAngleZ(int ang){
        for(var i: body){
            i.angZ = ang;
        }
    }*/

    public void move(Vector3f dir){
        body.stream().forEach((x)->{
            x.move(dir);
        });
        //computeCenter();
    }
    public void rotateTest(Vector3f rotation){
        //System.out.println(center);
        for (int o = 0; o < rubic_size; ++o) {
            for (int k = 0; k < rubic_size; ++k) {
                for (int l = 0; l < rubic_size; ++l) {
                   if(o == 0){
                       //System.out.println(cube[o][k][l].getCenter());
                       cube[o][k][l].body.stream().forEach((x)->{x.setCenter(new Vector3f(0f,0.5f,0.5f));});
                       cube[o][k][l].rotateX(rotation);
                   }
                }
            }
        }
    }
    public void update(){
        if (Input.isKeyDown(GLFW.GLFW_KEY_L)){
            rotateTest(new Vector3f(1,0,0));
        }
    }
}
