package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGame {

	
	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		//openGL expects vertices to be defined counter clockwise by default
		float[] vertices = {
				-0.5f, 0.5f, 0f,   //v0
				-0.5f, -0.5f, 0f,  //v1
				 0.5f, -0.5f, 0f,  //v2
				 0.5f, 0.5f, 0f    //v3
		};
		
		int[] indices = {
				0,1,3, //top left triangle (v0, v1, v3)
				3,1,2  //bottom right triangle (v3, v1, v2) 
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			renderer.render(model); 
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
	}
}