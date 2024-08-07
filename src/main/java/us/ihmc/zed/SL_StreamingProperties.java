// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing information about the properties of a streaming device. 
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_StreamingProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_StreamingProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_StreamingProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_StreamingProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_StreamingProperties position(long position) {
        return (SL_StreamingProperties)super.position(position);
    }
    @Override public SL_StreamingProperties getPointer(long i) {
        return new SL_StreamingProperties((Pointer)this).offsetAddress(i);
    }

	/**
	\brief IP address of the streaming device.
	 */
	public native @Cast("unsigned char") byte ip(int i); public native SL_StreamingProperties ip(int i, byte setter);
	@MemberGetter public native @Cast("unsigned char*") BytePointer ip();

	/**
	\brief Streaming port of the streaming device.
	<p>
	Default: 0
	 */
	public native @Cast("unsigned short") short port(); public native SL_StreamingProperties port(short setter);

	/**
	\brief Serial number of the streaming camera.
	<p>
	Default: 0
	 */
	public native @Cast("unsigned int") int serial_number(); public native SL_StreamingProperties serial_number(int setter);

	/**
	\brief Current bitrate of encoding of the streaming device.
	<p>
	Default: 0
	 */
	public native int current_bitrate(); public native SL_StreamingProperties current_bitrate(int setter);

	/**
	\brief Current codec used for compression in streaming device.
	<p>
	Default: \ref SL_STREAMING_CODEC_H265
	 */
	public native @Cast("SL_STREAMING_CODEC") int codec(); public native SL_StreamingProperties codec(int setter);
}
