// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
* \brief Structure representing a generic 2-dimensional unsigned integer vector.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Uint2 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Uint2() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Uint2(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Uint2(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Uint2 position(long position) {
        return (SL_Uint2)super.position(position);
    }
    @Override public SL_Uint2 getPointer(long i) {
        return new SL_Uint2((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Fist component of the vector.
	*/
	public native @Cast("unsigned int") int x(); public native SL_Uint2 x(int setter);
	/**
	\brief Second component of the vector.
	*/
	public native @Cast("unsigned int") int y(); public native SL_Uint2 y(int setter);
}
