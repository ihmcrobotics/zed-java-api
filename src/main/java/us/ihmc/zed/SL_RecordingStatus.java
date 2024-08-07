// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;


/**
\brief Structure containing information about the status of the recording.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_RecordingStatus extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_RecordingStatus() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_RecordingStatus(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_RecordingStatus(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_RecordingStatus position(long position) {
        return (SL_RecordingStatus)super.position(position);
    }
    @Override public SL_RecordingStatus getPointer(long i) {
        return new SL_RecordingStatus((Pointer)this).offsetAddress(i);
    }

	/**
     \brief Report if the recording has been enabled.
	 */
	public native @Cast("bool") boolean is_recording(); public native SL_RecordingStatus is_recording(boolean setter);
	/**
     \brief Report if the recording has been paused.
	 */
	public native @Cast("bool") boolean is_paused(); public native SL_RecordingStatus is_paused(boolean setter);
	/**
     \brief Status of current frame.
	 
	 True for success or false if the frame could not be written in the SVO file.
	 */
	public native @Cast("bool") boolean status(); public native SL_RecordingStatus status(boolean setter);
	/**
     \brief Compression time for the current frame in milliseconds.
	 */
	public native double current_compression_time(); public native SL_RecordingStatus current_compression_time(double setter);
	/**
     \brief Compression ratio (% of raw size) for the current frame.
	 */
	public native double current_compression_ratio(); public native SL_RecordingStatus current_compression_ratio(double setter);
	/**
     \brief Average compression time in milliseconds since beginning of recording.
	 */
	public native double average_compression_time(); public native SL_RecordingStatus average_compression_time(double setter);
	/**
     \brief Average compression ratio (% of raw size) since beginning of recording.
	 */
	public native double average_compression_ratio(); public native SL_RecordingStatus average_compression_ratio(double setter);
}
