// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing AI model status.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_AI_Model_status extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_AI_Model_status() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_AI_Model_status(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_AI_Model_status(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_AI_Model_status position(long position) {
        return (SL_AI_Model_status)super.position(position);
    }
    @Override public SL_AI_Model_status getPointer(long i) {
        return new SL_AI_Model_status((Pointer)this).offsetAddress(i);
    }

	/** \brief The model file is currently present on the host.*/
	public native @Cast("bool") boolean downloaded(); public native SL_AI_Model_status downloaded(boolean setter);
	/** \brief An engine file with the expected architecture is found.*/
	public native @Cast("bool") boolean optimized(); public native SL_AI_Model_status optimized(boolean setter);
}