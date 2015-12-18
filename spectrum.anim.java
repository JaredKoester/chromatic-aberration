import org.sunflow.SunflowAPI;
import org.sunflow.core.*;
import org.sunflow.core.camera.*;
import org.sunflow.core.primitive.*;
import org.sunflow.core.shader.*;
import org.sunflow.image.Color;
import org.sunflow.math.*;
import java.io.*;

public void build() {
	try {
	FileOutputStream fos = new FileOutputStream("spectrum.setting.sc");
	PrintWriter out = new PrintWriter(fos);

	out.println("camera {");
	out.println("type ChromaticAberrationLens");
	out.println("wavelength "+(405+getCurrentFrame()*10));
	out.println("eye    6 -1 -11");
	out.println("target 0 3 0");
	out.println("up     0 1 0");
	out.println("fov 45");
	out.println("aspect 1");
	out.println("fdist 12");
	out.println("lensr .2");

	/*
camera {
  type ChromaticAberrationLens
  wavelength 450
  eye    5 0 -50
  target 0 5 0
  up     0 1 0
  fov 45
  aspect 1
  fdist 50
  lensr .2
}
	*/
	
	out.println("}");
	out.flush();
	out.close();
	}
	catch(Exception e) {
	}

	parse("spectrum.setting.sc");
	parse("spectrum.nocamera.sc");
}

