// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing a set of parameters for the plane detection functionality.
<p>
The default constructor sets all parameters to their default settings.
\note Parameters can be adjusted by the user.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_PlaneDetectionParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_PlaneDetectionParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_PlaneDetectionParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_PlaneDetectionParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_PlaneDetectionParameters position(long position) {
        return (SL_PlaneDetectionParameters)super.position(position);
    }
    @Override public SL_PlaneDetectionParameters getPointer(long i) {
        return new SL_PlaneDetectionParameters((Pointer)this).offsetAddress(i);
    }


	/**
	 \brief Controls the spread of plane by checking the position difference.
	 <p>
	 Default: 0.15 meters
	 */
	public native float max_distance_threshold(); public native SL_PlaneDetectionParameters max_distance_threshold(float setter);

	/**
	 \brief Controls the spread of plane by checking the angle difference.
	 <p>
	 Default: 15 degrees
	 */
	public native float normal_similarity_threshold(); public native SL_PlaneDetectionParameters normal_similarity_threshold(float setter);
}