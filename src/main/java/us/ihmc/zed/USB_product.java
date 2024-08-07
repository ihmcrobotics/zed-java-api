// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class USB_product extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public USB_product() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public USB_product(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public USB_product(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public USB_product position(long position) {
        return (USB_product)super.position(position);
    }
    @Override public USB_product getPointer(long i) {
        return new USB_product((Pointer)this).offsetAddress(i);
    }

	public native int id_vendor(); public native USB_product id_vendor(int setter);
	public native int id_product(); public native USB_product id_product(int setter);
}
