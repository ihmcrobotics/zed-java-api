// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing information about the properties of a camera.
    
\note A \ref camera_model \ref SL_MODEL_ZED_M with an id '-1' can be due to an inverted USB-C cable.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_DeviceProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_DeviceProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_DeviceProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_DeviceProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_DeviceProperties position(long position) {
        return (SL_DeviceProperties)super.position(position);
    }
    @Override public SL_DeviceProperties getPointer(long i) {
        return new SL_DeviceProperties((Pointer)this).offsetAddress(i);
    }

	/**
	\brief State of the camera.
	<p>
	Default: \ref SL_CAMERA_STATE_NOT_AVAILABLE
	 */
	public native @Cast("SL_CAMERA_STATE") int camera_state(); public native SL_DeviceProperties camera_state(int setter);

	/**
	\brief Id of the camera.
	<p>
	Default: -1
	 */
	public native int id(); public native SL_DeviceProperties id(int setter);

	/**
	\brief System path of the camera
	 */
	public native @Cast("unsigned char") byte path(int i); public native SL_DeviceProperties path(int i, byte setter);
	@MemberGetter public native @Cast("unsigned char*") BytePointer path();
	/**
	\brief i2c port of the camera.
	 */
	public native int i2c_port(); public native SL_DeviceProperties i2c_port(int setter);
	/**
	\brief Model of the camera.
	 */
	public native @Cast("SL_MODEL") int camera_model(); public native SL_DeviceProperties camera_model(int setter);

	/**
	\brief Serial number of the camera.
	<p>
	Default: 0
    \warning Not provided for Windows.
	 */

	public native @Cast("unsigned int") int sn(); public native SL_DeviceProperties sn(int setter);
	/**
	\brief [Cam model, eeprom version, white balance param]
	 */
	public native @Cast("unsigned char") byte identifier(int i); public native SL_DeviceProperties identifier(int i, byte setter);
	@MemberGetter public native @Cast("unsigned char*") BytePointer identifier();
	/**
	\brief badge name (zedx_ar0234)
	 */
	public native @Cast("char*") BytePointer camera_badge(); public native SL_DeviceProperties camera_badge(BytePointer setter);

	/**
	\brief Name of sensor (zedx)
	 */
	public native @Cast("char*") BytePointer camera_sensor_model(); public native SL_DeviceProperties camera_sensor_model(BytePointer setter);
	/**
	\brief Name of Camera in DT (ZED_CAM1)
	 */
	public native @Cast("char*") BytePointer camera_name(); public native SL_DeviceProperties camera_name(BytePointer setter);
	/**
	\brief Input type of the camera.
	 */
	public native @Cast("SL_INPUT_TYPE") int input_type(); public native SL_DeviceProperties input_type(int setter);
	/**
	\brief sensor_address when available (ZED-X HDR/XOne HDR only)
	 */
	public native @Cast("unsigned char") byte sensor_address_left(); public native SL_DeviceProperties sensor_address_left(byte setter);
	public native @Cast("unsigned char") byte sensor_address_right(); public native SL_DeviceProperties sensor_address_right(byte setter);
}
