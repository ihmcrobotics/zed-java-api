// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Holds the options used to change the behavior of the body tracking module at runtime.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_BodyTrackingFusionRuntimeParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_BodyTrackingFusionRuntimeParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_BodyTrackingFusionRuntimeParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_BodyTrackingFusionRuntimeParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_BodyTrackingFusionRuntimeParameters position(long position) {
        return (SL_BodyTrackingFusionRuntimeParameters)super.position(position);
    }
    @Override public SL_BodyTrackingFusionRuntimeParameters getPointer(long i) {
        return new SL_BodyTrackingFusionRuntimeParameters((Pointer)this).offsetAddress(i);
    }

	/**
	 * \brief If the fused skeleton has less than skeleton_minimum_allowed_keypoints keypoints, it will be discarded.
	 * 
	 * Default: -1.
	 */
	public native int skeleton_minimum_allowed_keypoints(); public native SL_BodyTrackingFusionRuntimeParameters skeleton_minimum_allowed_keypoints(int setter);
	/**
	 * \brief If a skeleton was detected in less than skeleton_minimum_allowed_camera cameras, it will be discarded.
	 *
	 * Default: -1.
	 */
	public native int skeleton_minimum_allowed_camera(); public native SL_BodyTrackingFusionRuntimeParameters skeleton_minimum_allowed_camera(int setter);

	/**
	 * \brief This value controls the smoothing of the tracked or fitted fused skeleton.
	 * 
	 * It is ranged from 0 (low smoothing) and 1 (high smoothing).
	 * \n Default: 0.
	 */
	public native float skeleton_smoothing(); public native SL_BodyTrackingFusionRuntimeParameters skeleton_smoothing(float setter);
}