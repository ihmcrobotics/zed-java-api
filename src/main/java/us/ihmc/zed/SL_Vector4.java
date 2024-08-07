// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
* \brief Structure representing a generic 4-dimensional vector.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Vector4 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Vector4() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Vector4(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Vector4(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Vector4 position(long position) {
        return (SL_Vector4)super.position(position);
    }
    @Override public SL_Vector4 getPointer(long i) {
        return new SL_Vector4((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Fist component of the vector.
	*/
	public native float x(); public native SL_Vector4 x(float setter);
	/**
	\brief Second component of the vector.
	*/
	public native float y(); public native SL_Vector4 y(float setter);
	/**
	\brief Third component of the vector.
	*/
	public native float z(); public native SL_Vector4 z(float setter);
	/**
	\brief Forth component of the vector.
	*/
	public native float w(); public native SL_Vector4 w(float setter);
}
