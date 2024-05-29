// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;



/**
\brief Structure containing information of a single camera (serial number, model, input type, etc.)
<p>
That information about the camera will be returned by sl_get_camera_information().
<p>
\note This object is meant to be used as a read-only container, editing any of its field won't impact the SDK.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_CameraInformation extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_CameraInformation() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_CameraInformation(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_CameraInformation(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_CameraInformation position(long position) {
        return (SL_CameraInformation)super.position(position);
    }
    @Override public SL_CameraInformation getPointer(long i) {
        return new SL_CameraInformation((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Serial number of the camera.
	*/
	public native @Cast("unsigned int") int serial_number(); public native SL_CameraInformation serial_number(int setter);
	/**
	\brief Model of the camera (see \ref SL_MODEL).
	*/
	public native @Cast("SL_MODEL") int camera_model(); public native SL_CameraInformation camera_model(int setter);
	/**
	\brief Input type used in the ZED SDK.
	*/
	public native @Cast("SL_INPUT_TYPE") int input_type(); public native SL_CameraInformation input_type(int setter);
	/**
	\brief Camera configuration parameters stored in a \ref SL_CameraConfiguration.
	*/
	public native @ByRef SL_CameraConfiguration camera_configuration(); public native SL_CameraInformation camera_configuration(SL_CameraConfiguration setter);
	/**
	\brief Sensors configuration parameters stored in a \ref SL_SensorsConfiguration.
	*/
	public native @ByRef SL_SensorsConfiguration sensors_configuration(); public native SL_CameraInformation sensors_configuration(SL_SensorsConfiguration setter);
}
