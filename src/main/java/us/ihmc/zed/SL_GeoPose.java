// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
 * \brief Holds Geo reference position.
 *
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_GeoPose extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_GeoPose() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_GeoPose(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_GeoPose(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_GeoPose position(long position) {
        return (SL_GeoPose)super.position(position);
    }
    @Override public SL_GeoPose getPointer(long i) {
        return new SL_GeoPose((Pointer)this).offsetAddress(i);
    }

	/**
	 * The translation defining the pose in ENU.
	 */
	public native @ByRef SL_Vector3 translation(); public native SL_GeoPose translation(SL_Vector3 setter);
	/**
	 * The rotation defining the pose in ENU.
	 */
	public native @ByRef SL_Quaternion rotation(); public native SL_GeoPose rotation(SL_Quaternion setter);
	/**
	 * The pose covariance in ENU.
	 */
	public native float pose_covariance(int i); public native SL_GeoPose pose_covariance(int i, float setter);
	@MemberGetter public native FloatPointer pose_covariance();
	/**
	 * The horizontal accuracy.
	 */
	public native double horizontal_accuracy(); public native SL_GeoPose horizontal_accuracy(double setter);
	/**
	 * The vertical accuracy.
	*/
	public native double vertical_accuracy(); public native SL_GeoPose vertical_accuracy(double setter);
	/**
	 * The latitude, longitude, altitude.
	 */
	public native @ByRef SL_LatLng latlng_coordinates(); public native SL_GeoPose latlng_coordinates(SL_LatLng setter);
	/**
	 * The heading (orientation) of the pose in radians. It indicates the direction in which the object or observer is facing, with 0 degrees corresponding to North and increasing in a counter-clockwise direction.
	 */
	public native double heading(); public native SL_GeoPose heading(double setter);
	/**
	 * \brief The timestamp of SL_GeoPose.
	 *
	 */
	public native @Cast("uint64_t") long timestamp(); public native SL_GeoPose timestamp(long setter);
}
