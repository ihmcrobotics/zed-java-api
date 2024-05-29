// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing the results of the body tracking module.
<p>
The detected bodies/persons are listed in \ref body_list.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Bodies extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Bodies() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Bodies(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Bodies(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Bodies position(long position) {
        return (SL_Bodies)super.position(position);
    }
    @Override public SL_Bodies getPointer(long i) {
        return new SL_Bodies((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Number of detected bodies/persons.
	\note You can use it to iterate through the \ref body_list array.
	 */
	public native int nb_bodies(); public native SL_Bodies nb_bodies(int setter);
	/**
	\brief Timestamp corresponding to the frame acquisition. 
    <p>
    This value is especially useful for the async mode to synchronize the data.
	 */
	public native @Cast("unsigned long long") long timestamp(); public native SL_Bodies timestamp(long setter);
	/**
	\brief Whether \ref body_list has already been retrieved or not.
	 */
	public native int is_new(); public native SL_Bodies is_new(int setter);
	/**
	\brief Whether both the body tracking and the world orientation has been setup.
	 */
	public native int is_tracked(); public native SL_Bodies is_tracked(int setter);
	/**
	\brief Array of bodies/persons.
	\note Since the data is transmitted from C++ to C, the size of the structure must be constant.
	\note Therefore, there is a limitation of 75 objects in the image.
	 */
	public native @ByRef SL_BodyData body_list(int i); public native SL_Bodies body_list(int i, SL_BodyData setter);
	@MemberGetter public native SL_BodyData body_list();
}
