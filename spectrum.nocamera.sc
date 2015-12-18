image {
  resolution 1080 720
  aa 1 2
  samples 4
  filter gaussian
}

trace-depths {
  diff 1
  refl 4
  refr 4
}

light {
  type ibl
  image sky_small.hdr
  center 0 -1 0
  up 0 0 1
  lock true
  samples 200
}

light {
  type meshlight 
  name arealight1
  emit { "sRGB nonlinear" 1.0 1.0 1.0 }
  radiance 7.5
  samples 4
  points 4
	-25 50 -25
	 25 50 -25
     25 50  25
	-25 50  25
  triangles 2
  0 1 2
  0 2 3
}

shader {
  name plastic.shader
  type phong
  diff 0.1 0.1 0.1
  spec 0.1 0.1 0.1 30
  samples 4
}

object {
  shader plastic.shader
  transform {
	rotatey 0
	scaleu .75
	translate 0 0 0
  }
  type file-mesh
  name weathervane
  filename vane.stl
  smooth_normals true
}

shader {
  name default-shader
  type diffuse
  diff 0.25 0.25 0.25
}

object {
	shader default-shader
	type sphere
	c 0 0 0
	r .25
}