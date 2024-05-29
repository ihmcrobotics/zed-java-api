// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing the options used to initialize a camera.
<p>
This class allows you to select multiple parameters for the camera to open such as the selected camera, resolution, depth mode, coordinate system, and units of measurement.
\n Once filled with the desired options, it should be passed to the sl_open_camera() function.
<p>
\note For more info, read about the ZED SDK C++ class it mirrors:
<a href="https://www.stereolabs.com/docs/api/structsl_1_1InitParameters.html">InitParameters</a>
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_InitParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_InitParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_InitParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_InitParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_InitParameters position(long position) {
        return (SL_InitParameters)super.position(position);
    }
    @Override public SL_InitParameters getPointer(long i) {
        return new SL_InitParameters((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Defines the input source to initialize and open an camera from.
	
	The SDK can handle different input types:
	- Select a camera by its ID (<i>/dev/videoX</i> on Linux, and 0 to N cameras connected on Windows)
	- Select a camera by its serial number
	- Open a recorded sequence in the SVO file format
	- Open a streaming camera from its IP address and port
	<p>
	\note Available cameras and their id/serial number can be listed using sl_get_device_list() and sl_get_streaming_device_list().
	\note Each camera will create its own memory (CPU and GPU),
	therefore the number of cameras used at the same time can be limited by the configuration of your computer (GPU/CPU memory and capabilities).
	
	Default : (empty)
	\note See \ref SL_INPUT_TYPE for complementary information.
	*/
	public native @Cast("SL_INPUT_TYPE") int input_type(); public native SL_InitParameters input_type(int setter);

	/**
	\brief Desired camera resolution.
	
	\note Small resolutions offer higher framerate and lower computation time.
	\note In most situations, \ref SL_RESOLUTION_HD720 at 60 FPS is the best balance between image quality and framerate.
	<p>
	Default: <ul>
	<li>ZED X/X Mini: \ref SL_RESOLUTION_HD1200</li>
	<li>other cameras: \ref SL_RESOLUTION_HD720</li></ul>
	\note Available resolutions are listed here: \ref SL_RESOLUTION.
	 */
	public native @Cast("SL_RESOLUTION") int resolution(); public native SL_InitParameters resolution(int setter);

	/**
	\brief Requested camera frame rate.
        
	If set to 0, the highest FPS of the specified \ref camera_resolution will be used.
	\n Default: 0
	\n\n See \ref SL_RESOLUTION for a list of supported frame rates.
	\note If the requested \ref camera_fps is unsupported, the closest available FPS will be used.
	 */
	public native int camera_fps(); public native SL_InitParameters camera_fps(int setter);

	/**
	\brief Id for identifying which camera to use from the connected cameras.
	*/
	public native int camera_device_id(); public native SL_InitParameters camera_device_id(int setter);

	/**
	\brief Defines if a flip of the images is needed.
	
	If you are using the camera upside down, setting this parameter to \ref SL_FLIP_MODE_ON will cancel its rotation.
	\n The images will be horizontally flipped.
	\n Default: \ref SL_FLIP_MODE_OFF
	\note From ZED SDK 3.2 a new \ref SL_FLIP_MODE enum was introduced to add the automatic flip mode detection based on the IMU gravity detection.
	\note This does not work on \ref SL_MODEL_ZED cameras since they do not have the necessary sensors.
	*/
	public native @Cast("SL_FLIP_MODE") int camera_image_flip(); public native SL_InitParameters camera_image_flip(int setter);

	/**
	\brief Disables the self-calibration process at camera opening.
	
	At initialization, sl_open_camera() runs a self-calibration process that corrects small offsets from the device's factory calibration.
	\n A drawback is that calibration parameters will slightly change from one (live) run to another, which can be an issue for repeatability.
	\n If set to true, self-calibration will be disabled and calibration parameters won't be optimized, raw calibration parameters from the configuration file will be used.
	\n Default: false
	\note In most situations, self calibration should remain enabled.
	\note You can also trigger the self-calibration at anytime after sl_open_camera() by calling sl_update_self_calibration(), even if this parameter is set to true.
	*/
	public native @Cast("bool") boolean camera_disable_self_calib(); public native SL_InitParameters camera_disable_self_calib(boolean setter);

	/**
	\brief Enable the measurement computation on the right images.
	<p>
	By default, the ZED SDK only computes a single depth map, aligned with the left camera image.
	\n This parameter allows you to enable \ref SL_MEASURE_DEPTH_RIGHT and other \ref SL_MEASURE "SL_MEASURE_XXX_RIGHT" at the cost of additional computation time.
	\n For example, mixed reality pass-through applications require one depth map per eye, so this parameter can be activated.
	\n Default: false
	*/
	public native @Cast("bool") boolean enable_right_side_measure(); public native SL_InitParameters enable_right_side_measure(boolean setter);

	/**
	\brief Defines if the camera return the frame in real time mode.
	
	When playing back an SVO file, each call to \ref sl_grab() will extract a new frame and use it.
	\n However, it ignores the real capture rate of the images saved in the SVO file.
	\n Enabling this parameter will bring the SDK closer to a real simulation when playing back a file by using the images' timestamps.
	\n Default: false
	\note \ref sl_grab() will return an error when trying to play too fast, and frames will be dropped when playing too slowly.
	*/
	public native @Cast("bool") boolean svo_real_time_mode(); public native SL_InitParameters svo_real_time_mode(boolean setter);
	
	/**
	\brief \ref SL_DEPTH_MODE to be used.
	
	The ZED SDK offers several \ref SL_DEPTH_MODE, offering various levels of performance and accuracy.
	\n This parameter allows you to set the \ref SL_DEPTH_MODE that best matches your needs.
	\n Default: \ref SL_DEPTH_MODE_PERFORMANCE
	\note Available depth mode are listed here: \ref SL_DEPTH_MODE.
	*/
	public native @Cast("SL_DEPTH_MODE") int depth_mode(); public native SL_InitParameters depth_mode(int setter);
	
	/**
	\brief Defines whether the depth needs to be stabilized and to what extent.
	<p>
	Regions of generated depth map can oscillate from one frame to another.
	\n These oscillations result from a lack of texture (too homogeneous) on an object and by image noise.
	\n This parameter controls a stabilization filter that reduces these oscillations.
	\n In the range [0-100]: <ul>
	<li>0 disable the depth stabilization (raw depth will be return)</li>
	<li>stabilization smoothness is linear from 1 to 100</li></ul>
	Default: 1
	
	\note The stabilization uses the positional tracking to increase its accuracy, 
	so the positional tracking module will be enabled automatically when set to a value different from 0.
	\note Note that calling sl_enable_positional_tracking() with your own parameters afterwards is still possible.
	*/
	public native int depth_stabilization(); public native SL_InitParameters depth_stabilization(int setter);
	
	/**
	\brief Minimum depth distance to be returned, measured in the \ref SL_UNIT defined in \ref coordinate_unit.
	
	This parameter allows you to specify the minimum depth value (from the camera) that will be computed.
	
	\n In stereovision (the depth technology used by the camera), looking for closer depth values can have a slight impact on performance and memory consumption.
	\n On most modern GPUs, performance impact will be low. However, the impact of memory footprint will be visible.
	\n In cases of limited computation power, increasing this value can provide better performance.
	\n Default: -1 (corresponding values are available <a href="https://www.stereolabs.com/docs/depth-sensing/depth-settings#depth-range">here</a>)
	<p>
	\note \ref depth_minimum_distance value cannot be greater than 3 meters.
	\note 0 will imply that \ref depth_minimum_distance is set to the minimum depth possible for each camera
	(those values are available <a href="https://www.stereolabs.com/docs/depth-sensing/depth-settings#depth-range">here</a>).
		*/
	public native float depth_minimum_distance(); public native SL_InitParameters depth_minimum_distance(float setter);
	/**
	\brief Maximum depth distance to be returned, measured in the \ref SL_UNIT defined in \ref coordinate_unit.
	<p>
	When estimating the depth, the ZED SDK uses this upper limit to turn higher values into <b>inf</b> ones.
	\note Changing this value has no impact on performance and doesn't affect the positional tracking nor the spatial mapping.
	\note It only change values the depth, point cloud and normals.
	 */
	public native float depth_maximum_distance(); public native SL_InitParameters depth_maximum_distance(float setter);
	
	/**
	\brief Unit of spatial data (depth, point cloud, tracking, mesh, etc.) for retrieval.
	
	Default: \ref SL_UNIT_MILLIMETER
		*/
	public native @Cast("SL_UNIT") int coordinate_unit(); public native SL_InitParameters coordinate_unit(int setter);
	
	/**
	\brief \ref SL_COORDINATE_SYSTEM to be used as reference for positional tracking, mesh, point clouds, etc.
	<p>
	This parameter allows you to select the \ref SL_COORDINATE_SYSTEM used by the camera to return its measures.
	\n This defines the order and the direction of the axis of the coordinate system.
	\n Default: \ref SL_COORDINATE_SYSTEM_IMAGE
		*/
	public native @Cast("SL_COORDINATE_SYSTEM") int coordinate_system(); public native SL_InitParameters coordinate_system(int setter);
	
	/**
	\brief NVIDIA graphics card id to use.
	
	By default the SDK will use the most powerful NVIDIA graphics card found.
	\n However, when running several applications, or using several cameras at the same time, splitting the load over available GPUs can be useful.
	\n This parameter allows you to select the GPU used by the sl::Camera using an ID from 0 to n-1 GPUs in your PC.
	\n Default: -1
	\note A non-positive value will search for all CUDA capable devices and select the most powerful.
	 */
	public native int sdk_gpu_id(); public native SL_InitParameters sdk_gpu_id(int setter);

	/**
	\brief Enable the ZED SDK verbose mode.
	
	This parameter allows you to enable the verbosity of the ZED SDK to get a variety of runtime information in the console.
	\n When developing an application, enabling verbose (<code>\ref sdk_verbose >= 1</code>) mode can help you understand the current ZED SDK behavior.
	\n However, this might not be desirable in a shipped version.
	\n Default: 0 (no verbose message)
	\note The verbose messages can also be exported into a log file.
	 */
	public native int sdk_verbose(); public native SL_InitParameters sdk_verbose(int setter);
	/**
	\brief Requires the successful opening of the motion sensors before opening the camera.
	
	Default: false.
	<p>
	\note If set to false, the ZED SDK will try to <b>open and use</b> the IMU (second USB device on USB2.0) and will open the camera successfully even if the sensors failed to open.
	
	This can be used for example when using a USB3.0 only extension cable (some fiber extension for example).
	\note This parameter only impacts the LIVE mode.
	\note If set to true, sl_open_camera() will fail if the sensors cannot be opened.
	\note This parameter should be used when the IMU data must be available, such as object detection module or when the gravity is needed.
	
	\n\note This setting is not taken into account for \ref SL_MODEL_ZED camera since it does not include sensors.
	 */
	public native @Cast("bool") boolean sensors_required(); public native SL_InitParameters sensors_required(boolean setter);
	
	/**
	\brief Enable the Enhanced Contrast Technology, to improve image quality.
	<p>
	Default: true.
	
	\n If set to true, image enhancement will be activated in camera ISP. Otherwise, the image will not be enhanced by the IPS.
	\note This only works for firmware version starting from 1523 and up.
	 */
	public native @Cast("bool") boolean enable_image_enhancement(); public native SL_InitParameters enable_image_enhancement(boolean setter);

	/**
	\brief Define a timeout in seconds after which an error is reported if the sl_open_camera() function fails.
	<p>
	Set to '-1' to try to open the camera endlessly without returning error in case of failure.
	\n Set to '0' to return error in case of failure at the first attempt.
	\n Default: 5.0
	\note This parameter only impacts the LIVE mode.
	 */
	public native float open_timeout_sec(); public native SL_InitParameters open_timeout_sec(float setter);

	/**
	\brief Define the behavior of the automatic camera recovery during sl_grab() function call.
        
	When async is enabled and there's an issue with the communication with the camera,
	sl_grab() will exit after a short period and return the \ref SL_ERROR_CODE_CAMERA_REBOOTING warning.
	\n The recovery will run in the background until the correct communication is restored.
	\n When \ref async_grab_camera_recovery is false, the sl_grab() function is blocking and will return
	only once the camera communication is restored or the timeout is reached.
    \n Default: false
	 */
	public native @Cast("bool") boolean async_grab_camera_recovery(); public native SL_InitParameters async_grab_camera_recovery(boolean setter);

	/**
	\brief Define a computation upper limit to the grab frequency.
	<p>
	This can be useful to get a known constant fixed rate or limit the computation load while keeping a short exposure time by setting a high camera capture framerate.
	\n The value should be inferior to the SL_InitParameters::camera_fps and strictly positive.
	\note  It has no effect when reading an SVO file.
	
	This is an upper limit and won't make a difference if the computation is slower than the desired compute capping FPS.
	\note Internally the sl_grab() function always tries to get the latest available image while respecting the desired FPS as much as possible.
	 */
	public native float grab_compute_capping_fps(); public native SL_InitParameters grab_compute_capping_fps(float setter);
	/**
	 Enable or disable the image validity verification.
	 This will perform additional verification on the image to identify corrupted data. This verification is done in the grab function and requires some computations.
	 If an issue is found, the grab function will output a warning as sl::ERROR_CODE::CORRUPTED_FRAME.
	 This version doesn't detect frame tearing currently.
	 \n default: disabled
	 */
	public native @Cast("bool") boolean enable_image_validity_check(); public native SL_InitParameters enable_image_validity_check(boolean setter);
}
