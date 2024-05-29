// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing information about all the sensors available in the current device.
<p>
Information about the camera sensors is available in the \ref SL_CameraInformation struct returned by \ref sl_get_camera_information().
\note This structure is meant to be used as a read-only container.
\note Editing any of its fields will not impact the ZED SDK.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_SensorsConfiguration extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_SensorsConfiguration() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_SensorsConfiguration(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_SensorsConfiguration(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_SensorsConfiguration position(long position) {
        return (SL_SensorsConfiguration)super.position(position);
    }
    @Override public SL_SensorsConfiguration getPointer(long i) {
        return new SL_SensorsConfiguration((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Firmware version of the sensor module.
	\note 0 if no sensors are available (\ref SL_MODEL_ZED).
	*/
	public native @Cast("unsigned int") int firmware_version(); public native SL_SensorsConfiguration firmware_version(int setter);
	/**
	\brief IMU to left camera rotation (quaternion).
	\note It contains the rotation between the IMU frame and camera frame.
	*/
	public native @ByRef SL_Vector4 camera_ium_rotation(); public native SL_SensorsConfiguration camera_ium_rotation(SL_Vector4 setter);
	/**
	\brief IMU to left camera translation.
	\note It contains the translation between the IMU frame and camera frame.
	*/
	public native @ByRef SL_Vector3 camera_imu_translation(); public native SL_SensorsConfiguration camera_imu_translation(SL_Vector3 setter);
	/**
	\brief Magnetometer to IMU rotation (quaternion).
	\note It contains rotation between IMU frame and magnetometer frame.
	*/
	public native @ByRef SL_Vector4 ium_magnetometer_rotation(); public native SL_SensorsConfiguration ium_magnetometer_rotation(SL_Vector4 setter);
	/**
	\brief Magnetometer to IMU translation (quaternion).
	\note It contains translation between IMU frame and magnetometer frame.
	*/
	public native @ByRef SL_Vector3 ium_magnetometer_translation(); public native SL_SensorsConfiguration ium_magnetometer_translation(SL_Vector3 setter);
	/**
	\brief Configuration of the accelerometer.
	*/
	public native @ByRef SL_SensorParameters accelerometer_parameters(); public native SL_SensorsConfiguration accelerometer_parameters(SL_SensorParameters setter);
	/**
	\brief Configuration of the gyroscope.
	*/
	public native @ByRef SL_SensorParameters gyroscope_parameters(); public native SL_SensorsConfiguration gyroscope_parameters(SL_SensorParameters setter);
	/**
	\brief Configuration of the magnetometer.
	*/
	public native @ByRef SL_SensorParameters magnetometer_parameters(); public native SL_SensorsConfiguration magnetometer_parameters(SL_SensorParameters setter);
	/**
	\brief Configuration of the barometer.
	*/
	public native @ByRef SL_SensorParameters barometer_parameters(); public native SL_SensorsConfiguration barometer_parameters(SL_SensorParameters setter);
}
