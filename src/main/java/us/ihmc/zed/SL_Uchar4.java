// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
* \brief Structure representing an unsigned char 4-dimensional vector.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Uchar4 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Uchar4() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Uchar4(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Uchar4(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Uchar4 position(long position) {
        return (SL_Uchar4)super.position(position);
    }
    @Override public SL_Uchar4 getPointer(long i) {
        return new SL_Uchar4((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Fist component of the vector.
	*/
	public native @Cast("unsigned char") byte x(); public native SL_Uchar4 x(byte setter);
	/**
	\brief Second component of the vector.
	*/
	public native @Cast("unsigned char") byte y(); public native SL_Uchar4 y(byte setter);
	/**
	\brief Third component of the vector.
	*/
	public native @Cast("unsigned char") byte z(); public native SL_Uchar4 z(byte setter);
	/**
	\brief Fourth component of the vector.
	*/
	public native @Cast("unsigned char") byte w(); public native SL_Uchar4 w(byte setter);
}
