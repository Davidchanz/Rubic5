package engine.graphics;

import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class Vertex {
	private Vector3f position;
	private Vector2f textureCoord;
	private Vector3f color;
	
	public Vertex(Vector3f position, Vector2f textureCoord, Vector3f color) {
		this.position = position;
		this.textureCoord = textureCoord;
		this.color = color;
	}
	public Vector3f getPosition() {
		return position;
	}
	public Vector2f getTextureCoord() {
		return textureCoord;
	}
	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}
}