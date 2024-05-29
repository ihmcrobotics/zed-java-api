// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


// #endif

/**
\brief Structure defining the input type used in the ZED SDK.
<p>
It can be used to select a specific camera with an id or serial number, or from a SVO file.
*/
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_InputType extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_InputType() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_InputType(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_InputType(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_InputType position(long position) {
        return (SL_InputType)super.position(position);
    }
    @Override public SL_InputType getPointer(long i) {
        return new SL_InputType((Pointer)this).offsetAddress(i);
    }

	/**
	\brief Current input type.
	*/
	public native @Cast("SL_INPUT_TYPE") int input_type(); public native SL_InputType input_type(int setter);

	/**
	\brief Serial number of the camera.
	*/
	public native @Cast("unsigned int") int serial_number(); public native SL_InputType serial_number(int setter);

	/**
	\brief Id of the camera.
	*/
	public native @Cast("unsigned int") int id(); public native SL_InputType id(int setter);

	/**
	\brief Path to the SVO file.
	*/
	public native @Cast("char") byte svo_input_filename(int i); public native SL_InputType svo_input_filename(int i, byte setter);
	@MemberGetter public native @Cast("char*") BytePointer svo_input_filename();

	/**
	\brief IP address of the streaming camera.
	*/
	public native @Cast("char") byte stream_input_ip(int i); public native SL_InputType stream_input_ip(int i, byte setter);
	@MemberGetter public native @Cast("char*") BytePointer stream_input_ip();

	/**
	\brief Port of the streaming camera.
	*/
	public native @Cast("unsigned short") short stream_input_port(); public native SL_InputType stream_input_port(short setter);
}
