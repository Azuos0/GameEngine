package engineTester;

/*Descrição: Classe principal da aplicação.
 * Autor: Igor Vieira.
 * Data da última modificação: 10/10/2017.
 * Status: Em andamento.
 */


import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGame {

	
	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader(); 
		
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
		
		float[] textureCoords = {
				0,0,	//v0
				0,1,	//v1
				1,1,	//v2
				1,0		//v3
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("image3"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel); 
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
