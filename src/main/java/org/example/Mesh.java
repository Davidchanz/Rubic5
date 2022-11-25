package org.example;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh {
    private Vertex[] vertices;
    private int[] indices;
    private int VAO;
    private int PBO;
    private int IBO;

    Mesh(Vertex[] vertices, int[] indices){
        this.vertices = vertices;
        this.indices = indices;
    }
    public void create(){
        VAO = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(VAO);

        FloatBuffer positionBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
        float[] positionData = new float[vertices.length * 3];
        for(int i = 0; i < vertices.length; i++){
            positionData[i * 3] = vertices[i].getPosition().x;
            positionData[i * 3 + 1] = vertices[i].getPosition().y;
            positionData[i * 3 + 2] = vertices[i].getPosition().z;
        }
        positionBuffer.put(positionData).flip();

        PBO = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, PBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positionBuffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(0, 3, GL11.GL_UNSIGNED_INT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
        indicesBuffer.put(indices).flip();

        IBO = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, IBO);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public int getIBO() {
        return IBO;
    }

    public int getPBO() {
        return PBO;
    }

    public int getVAO() {
        return VAO;
    }

    public int[] getIndices() {
        return indices;
    }

    public Vertex[] getVertices() {
        return vertices;
    }
}
