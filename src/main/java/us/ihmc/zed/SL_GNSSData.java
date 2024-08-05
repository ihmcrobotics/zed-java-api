// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;



////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// GNSS API //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
\brief Structure containing GNSS data to be used for positional tracking as prior.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_GNSSData extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_GNSSData() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_GNSSData(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_GNSSData(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_GNSSData position(long position) {
        return (SL_GNSSData)super.position(position);
    }
    @Override public SL_GNSSData getPointer(long i) {
        return new SL_GNSSData((Pointer)this).offsetAddress(i);
    }

	/**
	 * \brief Longitude in radian.
	 * 
	 */
	public native double longitude(); public native SL_GNSSData longitude(double setter);
	/**
	 * \brief Latitude in radian.
	 * 
	 */
	public native double latitude(); public native SL_GNSSData latitude(double setter);
	/**
	 * \brief Altitude in meters.
	 * 
	 */
	public native double altitude(); public native SL_GNSSData altitude(double setter);
	/**
	 * \brief Timestamp of the GNSS position in nanoseconds (must be aligned with the camera time reference).
	 * 
	 */
	public native @Cast("unsigned long long") long ts(); public native SL_GNSSData ts(long setter);
	/**
	 * \brief Covariance of the position in meter (must be expressed in the ENU coordinate system).
	 * 
	 * For eph, epv GNSS sensors, set it as follow: <pre>{@code {eph*eph, 0, 0, 0, eph*eph, 0, 0, 0, epv*epv}}</pre>.
	 */
	public native double position_covariance(int i); public native SL_GNSSData position_covariance(int i, double setter);
	@MemberGetter public native DoublePointer position_covariance();
	/**
	 * \brief Longitude standard deviation.
	 *
	 */
	public native double longitude_std(); public native SL_GNSSData longitude_std(double setter);
	/**
	 * \brief Latitude standard deviation.
	 *
	 */
	public native double latitude_std(); public native SL_GNSSData latitude_std(double setter);
	/**
	 * \brief Altitude standard deviation.
	 *
	 */
	public native double altitude_std(); public native SL_GNSSData altitude_std(double setter);
}
