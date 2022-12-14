package org.example;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Matrix4f;
import engine.maths.Vector2f;
import engine.maths.Vector3f;
import engine.objects.GameObject;

import java.util.ArrayList;
import java.util.Collection;

//todo

/**Class for scene object which especially is a list of AbstractShape elements*/
public class ShapeObject extends EngineObject{
    public ArrayList<GameObject> body;//set of Abstract shape
    public String name;//name
    public Vector3f normal;
    /**ShapeObject constructor
     * ini all members default*/
    public ShapeObject(){
        this.id = 0;//ini id
        this.name = "Template";//ini name
        this.body = new ArrayList<>();//ini body
        this.rotation = new Vector3f(0,0,0);
        this.center = new Vector3f(0,0,0);
        this.position = new Vector3f(0,0,0);
    }
    /**ShapeObject constructor
     * ini name and id*/
    public ShapeObject(String name, int id){
        this();//invoke default constructor
        this.id = id;//ini id
        this.name = name;//ini name
    }
    /**ShapeObject constructor
     * ini id name adn position*/
    public ShapeObject(String name, int id, Vector3f pos){
        this(name, id);//ini name id constructor
        this.position = new Vector3f(pos);//ini position
    }
    /**Method move*/
    public void move(Vector3f dir){
        this.position = Vector3f.add(this.position, dir);//move position on dir
        //this.center = Vector3f.add(this.center, dir);//move center on dir TODO
        for(var i: this.body){
            i.setPosition(dir);//move all AbstractShapes
        }
    }
    /**Add new element on object*/
    public GameObject add(GameObject o){
        //o.id = this.id;//ini new shape id
        o.setRotation(this.getRotation());//Vector3f.add(o.getRotation(), this.getRotation());
        this.body.add(o);//add new shape in body
        float sumX=0;
        float sumY=0;
        float sumZ=0;
        for(var i: this.body){
            sumX+= i.getCenter().getX() + i.getPosition().getX();//compute sum centers X
            sumY+= i.getCenter().getY() + i.getPosition().getY();;//compute sum centers Y
            sumZ+= i.getCenter().getZ() + i.getPosition().getZ();;//compute sum centers Z
        }
        this.center = new Vector3f(sumX/this.body.size(), sumY/this.body.size(), sumZ/this.body.size());//ini center
        Vector3f.add(this.getPosition(), o.getPosition());//ini position
        for(var i: this.body){
            i.setParent(this);//ini shape parent
        }
        return o;
    }
    /**Add new element collection on object*/
    public void addAll(Collection<GameObject> o){
        for(var i : o){
            add(i);//invoke add single add() for all new shapes in collections
        }
    }
    public void rotateX(Vector3f rotation){
        this.rotation = Vector3f.add(this.rotation, rotation);
        for(var i: this.body){
            i.setRotation(rotation);
        }
    }
}
