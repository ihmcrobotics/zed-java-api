// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing information about a single sensor available in the current device.
<p>
Information about the camera sensors is available in the \ref SL_CameraInformation struct returned by \ref sl_get_camera_information().
\note This structure is meant to be used as a read-only container.
\note Editing any of its fields will not impact the ZED SDK.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_SensorParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_SensorParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_SensorParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_SensorParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_SensorParameters position(long position) {
        return (SL_SensorParameters)super.position(position);
    }
    @Override public SL_SensorParameters getPointer(long i) {
        return new SL_SensorParameters((Pointer)this).offsetAddress(i);
    }

	/** \brief Type of the sensor.*/
	public native @Cast("SL_SENSOR_TYPE") int type(); public native SL_SensorParameters type(int setter);
	/** \brief Resolution of the sensor. */
	public native float resolution(); public native SL_SensorParameters resolution(float setter);
	/** \brief Sampling rate (or ODR) of the sensor. */
	public native float sampling_rate(); public native SL_SensorParameters sampling_rate(float setter);
	/** \brief Range of the sensor (minimum: {@code range.x}, maximum: {@code range.y}). */
	public native @ByRef SL_Vector2 range(); public native SL_SensorParameters range(SL_Vector2 setter);
	/** \brief White noise density given as continuous (frequency-independent).\note The units will be expressed in <pre>{@code sensor_unit / √(Hz)}</pre>.\note {@code NAN} if the information is not available. */
	public native float noise_density(); public native SL_SensorParameters noise_density(float setter);
	/** \brief Random walk derived from the Allan Variance given as continuous (frequency-independent).\note The units will be expressed in <pre>{@code sensor_unit / √(Hz)}</pre>.\note {@code NAN} if the information is not available. */
	public native float random_walk(); public native SL_SensorParameters random_walk(float setter);
	/** \brief Unit of the sensor. */
	public native @Cast("SL_SENSORS_UNIT") int sensor_unit(); public native SL_SensorParameters sensor_unit(int setter);
	/** \brief Whether the sensor is available in your camera.*/
	public native @Cast("bool") boolean is_available(); public native SL_SensorParameters is_available(boolean setter);
}
