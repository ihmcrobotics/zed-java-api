// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


// #if 0

// #endif

/**
\brief Structure defining a 2D rectangle with top-left corner coordinates and width/height in pixels.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_Rect extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_Rect() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_Rect(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_Rect(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_Rect position(long position) {
        return (SL_Rect)super.position(position);
    }
    @Override public SL_Rect getPointer(long i) {
        return new SL_Rect((Pointer)this).offsetAddress(i);
    }

	/** 
	\brief x coordinates of top-left corner.
	*/
	public native int x(); public native SL_Rect x(int setter);
	/** 
	\brief y coordinates of top-left corner.
	*/
	public native int y(); public native SL_Rect y(int setter);
	/** 
	\brief Width of the rectangle in pixels.
	*/
	public native int width(); public native SL_Rect width(int setter);
	/** 
	\brief Height of the rectangle in pixels.
	*/
	public native int height(); public native SL_Rect height(int setter);
}
