// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Lists the different status of positional tracking.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_PositionalTrackingStatus extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_PositionalTrackingStatus() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_PositionalTrackingStatus(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_PositionalTrackingStatus(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_PositionalTrackingStatus position(long position) {
        return (SL_PositionalTrackingStatus)super.position(position);
    }
    @Override public SL_PositionalTrackingStatus getPointer(long i) {
        return new SL_PositionalTrackingStatus((Pointer)this).offsetAddress(i);
    }

	/**
	\brief  Represents the current state of Visual-Inertial Odometry (VIO) tracking between the previous frame and the current frame.
	*/
	public native @Cast("SL_ODOMETRY_STATUS") int odometry_status(); public native SL_PositionalTrackingStatus odometry_status(int setter);
	/**
	\brief  Represents the current state of camera tracking in the global map.
	*/
	public native @Cast("SL_SPATIAL_MEMORY_STATUS") int spatial_memory_status(); public native SL_PositionalTrackingStatus spatial_memory_status(int setter);
	/**
	\brief  Represents the current state of positional tracking fusion.
	*/
	public native @Cast("SL_POSITIONAL_TRACKING_FUSION_STATUS") int tracking_fusion_status(); public native SL_PositionalTrackingStatus tracking_fusion_status(int setter);
}
