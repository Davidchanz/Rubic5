package engine.objects;

import engine.graphics.Mesh;
import engine.maths.Vector3f;
import org.example.ShapeObject;

public class GameObject {
	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	private Vector3f center;
	protected Vector3f normal;
	private Mesh mesh;
	private ShapeObject parent;

	public GameObject(){

	}
	public void build(Vector3f position, Vector3f rotation, Vector3f scale, Vector3f normal, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.normal = normal;
		this.mesh = mesh;
		this.center = new Vector3f(0,0,0);
	}
	public GameObject(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;

		this.center = new Vector3f(0,0,0);
	}
	
	public void update() {
		position.setZ(position.getZ() - 0.05f);
	}

	public Vector3f getPosition() {
		return position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public Mesh getMesh() {
		return mesh;
	}
	public void setRotation(Vector3f rotation){
		this.rotation = Vector3f.add(this.rotation, rotation);
	}
	public void setPosition(Vector3f position){
		this.position = Vector3f.add(this.position, position);
	}
	public void setCenter(Vector3f center){
		this.center = center;
	}
	public Vector3f getCenter() {
		return center;
	}

	public ShapeObject getParent() {
		return parent;
	}

	public void setParent(ShapeObject parent) {
		this.parent = parent;
	}
}