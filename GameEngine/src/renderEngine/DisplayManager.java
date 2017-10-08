/*Descri��o: Classe respons�vel por gerenciar as telas da aplica��o.
 * Autor: Igor Vieira.
 * Data da �ltima modifica��o: 02/10/2017.
 * Status: Em andamento.
 */


package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720; 
	private static final int FPS_CAP = 120;
	
	//m�todo respons�vel por criar as telas
	public static void createDisplay() {
		
		ContextAttribs attribs = 
				new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("First Display");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	//m�todo respons�veil por atualizar as telas
	public static void updateDisplay() {
		//respons�vel por sincronizar a tela com o fps
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	//m�todo respons�vel por encerrar a tela
	public static void closeDisplay() {
		
	}
}
