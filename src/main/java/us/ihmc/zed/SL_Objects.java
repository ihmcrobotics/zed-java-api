// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing the results of the object detection module.
<p>
The detected objects are listed in \ref object_list.
\note Since the data is transmitted from C++ to C, the size of the structure must be constant.
\note Therefore, there is a limitation of 75 objects in the image.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Objects extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Objects() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Objects(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Objects(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Objects position(long position) {
        return (SL_Objects)super.position(position);
    }
    @Override public SL_Objects getPointer(long i) {
        return new SL_Objects((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Number of detected objects.
	\note You can use it to iterate through the \ref object_list array.
	 */
	public native int nb_objects(); public native SL_Objects nb_objects(int setter);
	/**
	\brief Timestamp corresponding to the frame acquisition. 
    <p>
    This value is especially useful for the async mode to synchronize the data.
	 */
	public native @Cast("uint64_t") long timestamp(); public native SL_Objects timestamp(long setter);
	/**
	\brief Whether \ref object_list has already been retrieved or not.
	 */
	public native int is_new(); public native SL_Objects is_new(int setter);
	/**
	\brief Whether both the object tracking and the world orientation has been setup.
	 */
	public native int is_tracked(); public native SL_Objects is_tracked(int setter);
	/**
	\brief Current \ref SL_OBJECT_DETECTION_MODEL used.
	 */
	public native @Cast("SL_OBJECT_DETECTION_MODEL") int detection_model(); public native SL_Objects detection_model(int setter);
	/**
	\brief Array of detected objects.
	\note Since the data is transmitted from C++ to C, the size of the structure must be constant.
	\note Therefore, there is a limitation of 75 objects in the image.
	 */
	public native @ByRef SL_ObjectData object_list(int i); public native SL_Objects object_list(int i, SL_ObjectData setter);
	@MemberGetter public native SL_ObjectData object_list();
}
