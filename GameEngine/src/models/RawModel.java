package models;


//representa a classe 3D model na memória
public class RawModel {
	
	private int VaoID;
	private int vertexCount;
	
	public RawModel(int VaoID, int vertexCount) {
		this.VaoID = VaoID;
		this.vertexCount = vertexCount;
	}

	public int getVaoID() {
		return VaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
	
}
