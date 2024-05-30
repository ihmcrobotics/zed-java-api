// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Useful struct to store the Fusion configuration, can be read from /write to a JSON file.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_FusionConfiguration extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_FusionConfiguration() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_FusionConfiguration(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_FusionConfiguration(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_FusionConfiguration position(long position) {
        return (SL_FusionConfiguration)super.position(position);
    }
    @Override public SL_FusionConfiguration getPointer(long i) {
        return new SL_FusionConfiguration((Pointer)this).offsetAddress(i);
    }

	/**
	The serial number of the used ZED camera.
	*/
	public native int serial_number(); public native SL_FusionConfiguration serial_number(int setter);

	/**
	The communication parameters to connect this camera to the Fusion.
	*/
	public native @ByRef SL_CommunicationParameters comm_param(); public native SL_FusionConfiguration comm_param(SL_CommunicationParameters setter);

	/**
	The WORLD SL_Vector3 of the camera for Fusion.
	*/
	public native @ByRef @Name("position") SL_Vector3 _position(); public native SL_FusionConfiguration _position(SL_Vector3 setter);

	/**
	The WORLD SL_Quaternion of the camera for Fusion.
	*/
	public native @ByRef SL_Quaternion rotation(); public native SL_FusionConfiguration rotation(SL_Quaternion setter);

	/**
	The input type for the current camera.
	*/
	public native @ByRef SL_InputType input_type(); public native SL_FusionConfiguration input_type(SL_InputType setter);
}