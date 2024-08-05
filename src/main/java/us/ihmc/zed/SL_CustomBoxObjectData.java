// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure that store externally detected objects.
<p>
The objects can be ingested with sl_ingest_custom_box_objects() to extract 3D and tracking information over time.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_CustomBoxObjectData extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_CustomBoxObjectData() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_CustomBoxObjectData(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_CustomBoxObjectData(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_CustomBoxObjectData position(long position) {
        return (SL_CustomBoxObjectData)super.position(position);
    }
    @Override public SL_CustomBoxObjectData getPointer(long i) {
        return new SL_CustomBoxObjectData((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Unique id to help identify and track AI detections.
    <p>
    It can be either generated externally, or by using \ref sl_generate_unique_id() or left empty.
	*/
	public native @Cast("char") byte unique_object_id(int i); public native SL_CustomBoxObjectData unique_object_id(int i, byte setter);
	@MemberGetter public native @Cast("char*") BytePointer unique_object_id();
	/**
	\brief 2D bounding box of the object represented as four 2D points starting at the top left corner and rotation clockwise.
	\note Expressed in pixels on the original image resolution, <pre>{@code [0, 0]}</pre> is the top left corner.
	<pre>{@code
	A ------ B
	| Object |
	D ------ C
	}</pre>
	*/
	public native @ByRef SL_Vector2 bounding_box_2d(int i); public native SL_CustomBoxObjectData bounding_box_2d(int i, SL_Vector2 setter);
	@MemberGetter public native SL_Vector2 bounding_box_2d();

	/**
	\brief Object label.
	<p>
	This information is passed-through and can be used to improve object tracking.
	\note It should define an object class. This means that any similar object (in classification) should share the same label number.
	*/
	public native int label(); public native SL_CustomBoxObjectData label(int setter);

	/**
	\brief Detection confidence value of the object.
	\note The value should be in <pre>{@code [0-1]}</pre>.
	\note It can be used to improve the object tracking.
	*/
	public native float probability(); public native SL_CustomBoxObjectData probability(float setter);
	/**
	\brief Provide hypothesis about the object movements (degrees of freedom or DoF) to improve the object tracking.
	- true: 2 DoF projected alongside the floor plane. Case for object standing on the ground such as person, vehicle, etc. 
	\n The projection implies that the objects cannot be superposed on multiple horizontal levels. 
	- false: 6 DoF (full 3D movements are allowed).
	<p>
	\note This parameter cannot be changed for a given object tracking id.
	\note It is advised to set it by labels to avoid issues.
	*/
	public native @Cast("bool") boolean is_grounded(); public native SL_CustomBoxObjectData is_grounded(boolean setter);
}
