// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing a set of runtime properties of a certain class ID for the object detection module using a custom model.
<p>
The default constructor sets all parameters to their default settings.
\note Parameters can be adjusted by the user.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_CustomObjectDetectionProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_CustomObjectDetectionProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_CustomObjectDetectionProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_CustomObjectDetectionProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_CustomObjectDetectionProperties position(long position) {
        return (SL_CustomObjectDetectionProperties)super.position(position);
    }
    @Override public SL_CustomObjectDetectionProperties getPointer(long i) {
        return new SL_CustomObjectDetectionProperties((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Index of the class represented by this set of properties.
	*/
	public native int class_id(); public native SL_CustomObjectDetectionProperties class_id(int setter);

	/**
	\brief Whether the object object is kept or not.
	*/
	public native @Cast("bool") boolean enabled(); public native SL_CustomObjectDetectionProperties enabled(boolean setter);

	/**
	\brief Confidence threshold.
	<p>
	From 1 to 100, with 1 meaning a low threshold, more uncertain objects and 99 very few but very precise objects.
	\n Default: 20.f
	\note If the scene contains a lot of objects, increasing the confidence can slightly speed up the process, since every object instance is tracked.
	*/
	public native float detection_confidence_threshold(); public native SL_CustomObjectDetectionProperties detection_confidence_threshold(float setter);

	/**
	\brief Provide hypothesis about the object movements (degrees of freedom or DoF) to improve the object tracking.
	- true: 2 DoF projected alongside the floor plane. Case for object standing on the ground such as person, vehicle, etc. 
	\n The projection implies that the objects cannot be superposed on multiple horizontal levels. 
	- false: 6 DoF (full 3D movements are allowed).
	<p>
	\note This parameter cannot be changed for a given object tracking id.
	\note It is advised to set it by labels to avoid issues.
	*/
	public native @Cast("bool") boolean is_grounded(); public native SL_CustomObjectDetectionProperties is_grounded(boolean setter);

	/**
	\brief Provide hypothesis about the object staticity to improve the object tracking.
		- true: the object will be assumed to never move nor being moved.
		- false: the object will be assumed to be able to move or being moved.
	*/
	public native @Cast("bool") boolean is_static(); public native SL_CustomObjectDetectionProperties is_static(boolean setter);

	/**
	\brief Maximum tracking time threshold (in seconds) before dropping the tracked object when unseen for this amount of time.
	<p>
	By default, let the tracker decide internally based on the internal sub class of the tracked object.
	Only valid for static object.
	*/
	public native float tracking_timeout(); public native SL_CustomObjectDetectionProperties tracking_timeout(float setter);

	/**
	\brief Maximum tracking distance threshold (in meters) before dropping the tracked object when unseen for this amount of meters.
	<p>
	By default, do not discard tracked object based on distance.
	Only valid for static object.
	*/
	public native float tracking_max_dist(); public native SL_CustomObjectDetectionProperties tracking_max_dist(float setter);

	/**
	\brief Maximum allowed width normalized to the image size.
	<p>
	Any prediction bigger than that will be filtered out.
	Default: -1 (no filtering)
	*/
	public native float max_box_width_normalized(); public native SL_CustomObjectDetectionProperties max_box_width_normalized(float setter);

	/**
	\brief Minimum allowed width normalized to the image size.
	<p>
	Any prediction smaller than that will be filtered out.
	Default: -1 (no filtering)
	*/
	public native float min_box_width_normalized(); public native SL_CustomObjectDetectionProperties min_box_width_normalized(float setter);

	/**
	\brief Maximum allowed height normalized to the image size.
	<p>
	Any prediction bigger than that will be filtered out.
	Default: -1 (no filtering)
	*/
	public native float max_box_height_normalized(); public native SL_CustomObjectDetectionProperties max_box_height_normalized(float setter);

	/**
	\brief Minimum allowed height normalized to the image size.
	<p>
	Any prediction smaller than that will be filtered out.
	Default: -1 (no filtering)
	*/
	public native float min_box_height_normalized(); public native SL_CustomObjectDetectionProperties min_box_height_normalized(float setter);
}
