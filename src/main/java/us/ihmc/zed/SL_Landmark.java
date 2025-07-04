// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Represents a 3d landmark.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Landmark extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Landmark() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Landmark(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Landmark(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Landmark position(long position) {
        return (SL_Landmark)super.position(position);
    }
    @Override public SL_Landmark getPointer(long i) {
        return new SL_Landmark((Pointer)this).offsetAddress(i);
    }

	/**
	 \brief Unique identifier for the landmark.
	 */
	public native @Cast("uint64_t") long id(); public native SL_Landmark id(long setter);
	/**
	 \brief World position of the landmark.
	 */
	public native @ByRef @Name("position") SL_Vector3 _position(); public native SL_Landmark _position(SL_Vector3 setter);
}
