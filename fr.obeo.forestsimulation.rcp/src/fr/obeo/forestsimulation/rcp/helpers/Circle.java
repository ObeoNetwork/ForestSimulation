package fr.obeo.forestsimulation.rcp.helpers;

/**
 * Original code by Martin Simons.
 * Created by Oki Wan Ben0bi @ 2015
 */

import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Copied from https://hub.jmonkeyengine.org/t/drawing-a-simple-circle-in-jme3/15461/13
 * @author Arthur Daussy
 *
 */
public class Circle extends Mesh {
	private Vector3f center;
	private float radius;
	private int sampleCount;

	public Circle(float radius) {
		this(Vector3f.ZERO, radius, 16);
	}

	public Circle(float radius, int samples) {
		this(Vector3f.ZERO, radius, samples);
	}

	public Circle(Vector3f center, float radius, int samples) {
		super();

		this.center = center;
		this.radius = radius;
		this.sampleCount = samples;

		setMode(Mode.Lines);
		updateGeometry();
	}

	protected void updateGeometry() {
		FloatBuffer positions = BufferUtils.createFloatBuffer(sampleCount * 3);
		FloatBuffer normals = BufferUtils.createFloatBuffer(sampleCount * 3);
		short[] indices = new short[sampleCount * 2];

		float rate = FastMath.TWO_PI / (float) sampleCount;
		float angle = 0;

		int idc = 0;
		for (int i = 0; i < sampleCount; i++) {
			float x = FastMath.cos(angle) * radius + center.x;
			float z = FastMath.sin(angle) * radius + center.z;

			positions.put(x).put(center.y).put(z);
			normals.put(new float[] { 0, 1, 0 });

			indices[idc++] = (short) i;
			if (i < sampleCount - 1)
				indices[idc++] = (short) (i + 1);
			else
				indices[idc++] = 0;

			angle += rate;
		}

		setBuffer(Type.Position, 3, positions);
		setBuffer(Type.Normal, 3, normals);
		setBuffer(Type.Index, 2, indices);

		setBuffer(Type.TexCoord, 2, new float[] { 0, 0, 1, 1 });
		updateBound();
	}
}