// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
 * \brief Holds the options used for initializing the positional tracking fusion module.
 *
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_PositionalTrackingFusionParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_PositionalTrackingFusionParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_PositionalTrackingFusionParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_PositionalTrackingFusionParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_PositionalTrackingFusionParameters position(long position) {
        return (SL_PositionalTrackingFusionParameters)super.position(position);
    }
    @Override public SL_PositionalTrackingFusionParameters getPointer(long i) {
        return new SL_PositionalTrackingFusionParameters((Pointer)this).offsetAddress(i);
    }

	/**
	 * \brief This attribute is responsible for enabling or not GNSS positional tracking fusion.
	 *
	 * Default: false
	 */
	public native @Cast("bool") boolean enable_GNSS_fusion(); public native SL_PositionalTrackingFusionParameters enable_GNSS_fusion(boolean setter);
	/**
	 * \brief Control the VIO / GNSS calibration process.
	 * 
	 */
	public native @ByRef SL_GNSSCalibrationParameters gnss_calibration_parameters(); public native SL_PositionalTrackingFusionParameters gnss_calibration_parameters(SL_GNSSCalibrationParameters setter);
}
