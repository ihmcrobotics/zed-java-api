// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;



/**
\brief Structure containing a set of parameters for the positional tracking module initialization.
<p>
The default constructor sets all parameters to their default settings.
\note Parameters can be user adjusted.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_PositionalTrackingParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_PositionalTrackingParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_PositionalTrackingParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_PositionalTrackingParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_PositionalTrackingParameters position(long position) {
        return (SL_PositionalTrackingParameters)super.position(position);
    }
    @Override public SL_PositionalTrackingParameters getPointer(long i) {
        return new SL_PositionalTrackingParameters((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Rotation of the camera in the world frame when the camera is started.
	<p>
	Default: Identity quaternion
	*/
	public native @ByRef SL_Quaternion initial_world_rotation(); public native SL_PositionalTrackingParameters initial_world_rotation(SL_Quaternion setter);
	/**
	\brief Position of the camera in the world frame when the camera is started.
	<p>
	Default: Null vector
	*/
	public native @ByRef SL_Vector3 initial_world_position(); public native SL_PositionalTrackingParameters initial_world_position(SL_Vector3 setter);
	/**
	\brief Whether the camera can remember its surroundings.
	<p>
	This helps correct positional tracking drift and can be helpful for positioning different cameras relative to one other in space.
	\n Default: true
	<p>
	\warning This mode requires more resources to run, but greatly improves tracking accuracy.
	\warning We recommend leaving it on by default.
	*/
	public native @Cast("bool") boolean enable_area_memory(); public native SL_PositionalTrackingParameters enable_area_memory(boolean setter);
	/**
	\brief Whether to enable smooth pose correction for small drift correction.
    <p>
    Default: false
	*/
	public native @Cast("bool") boolean enable_pose_smoothing(); public native SL_PositionalTrackingParameters enable_pose_smoothing(boolean setter);
	/**
	\brief Initializes the tracking to be aligned with the floor plane to better position the camera in space.
	<p>
	Default: false
	\note This launches floor plane detection in the background until a suitable floor plane is found.
	\note The tracking will start in \ref SL_POSITIONAL_TRACKING_STATE_SEARCHING state.
	<p>
	\warning This features does not work with \ref SL_MODEL_ZED since it needs an IMU to classify the floor.
	\warning The camera needs to look at the floor during initialization for optimum results.
	*/
	public native @Cast("bool") boolean set_floor_as_origin(); public native SL_PositionalTrackingParameters set_floor_as_origin(boolean setter);
	/**
	\brief Whether to define the camera as static.
	
	If true, it will not move in the environment. This allows you to set its position using \ref initial_world_position and \ref initial_world_rotation.
	\n All ZED SDK functionalities requiring positional tracking will be enabled without additional computation.
	\n \ref sl_get_position() will return the values set as \ref initial_world_position and \ref initial_world_rotation.
	\n Default: false
	*/
	public native @Cast("bool") boolean set_as_static(); public native SL_PositionalTrackingParameters set_as_static(boolean setter);
	/**
	\brief Whether to enable the IMU fusion.
	<p>
	When set to false, only the optical odometry will be used.
	\n Default: true
	\note This setting has no impact on the tracking of a camera.
	\note \ref SL_MODEL_ZED does not have an IMU.
	*/
	public native @Cast("bool") boolean enable_imu_fusion(); public native SL_PositionalTrackingParameters enable_imu_fusion(boolean setter);
	/**
	\brief Whether to enable the IMU fusion.
	<p>
	When set to false, only the optical odometry will be used.
	\n Default: true
	\note This setting has no impact on the tracking of a camera
	\note \ref SL_MODEL_ZED does not have an IMU.
	 */
	public native float depth_min_range(); public native SL_PositionalTrackingParameters depth_min_range(float setter);
	/**
	\brief Whether to override 2 of the 3 components from \ref initial_world_rotation using the IMU gravity.
	<p>
	Default: true
	\note This parameter does nothing on sl.ZED.MODEL since it does not have an IMU.
	 */
	public native @Cast("bool") boolean set_gravity_as_origin(); public native SL_PositionalTrackingParameters set_gravity_as_origin(boolean setter);
	/**
	\brief Positional tracking mode used.
	
	Can be used to improve accuracy in some types of scene at the cost of longer runtime.
	\n Default: \ref SL_POSITIONAL_TRACKING_MODE_GEN_1
	*/
	public native @Cast("SL_POSITIONAL_TRACKING_MODE") int mode(); public native SL_PositionalTrackingParameters mode(int setter);
}
