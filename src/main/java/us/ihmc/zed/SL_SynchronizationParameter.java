// Targeted by JavaCPP version 1.5.10: DO NOT EDIT THIS FILE

package us.ihmc.zed;

import org.bytedeco.cuda.cudart.CUctx_st;
import org.bytedeco.cuda.cudart.CUstream_st;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static us.ihmc.zed.global.zed.*;



/**
 * \brief Configuration parameters for data synchronization.
 *
 * The SynchronizationParameter struct represents the configuration parameters used by the synchronizer. It allows customization
 * of the synchronization process based on specific requirements.
 */
@Properties(inherit = us.ihmc.zed.ZEDJavaAPIConfig.class)
public class SL_SynchronizationParameter extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public SL_SynchronizationParameter() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SL_SynchronizationParameter(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SL_SynchronizationParameter(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public SL_SynchronizationParameter position(long position) {
        return (SL_SynchronizationParameter)super.position(position);
    }
    @Override public SL_SynchronizationParameter getPointer(long i) {
        return new SL_SynchronizationParameter((Pointer)this).offsetAddress(i);
    }

	/**
	 * \brief Size of synchronization windows in milliseconds.
	 *
	 * The synchronization window is used by the synchronizer to return all data present inside the current
	 * synchronization window. For efficient fusion, the synchronization window size is expected to be equal
	 * to the mean {@code grab()} duration of the camera at the lowest FPS. If not provided, the fusion SDK will compute it from the
	 * data's sources.
	 * 
	 * Default value: 0
	 */
	public native double windows_size(); public native SL_SynchronizationParameter windows_size(double setter);

	/**
	 * \brief Duration in milliseconds before considering a camera as inactive if no more data is present (for example camera disconnection).
	 *
	 * The data_source_timeout parameter specifies the duration to wait before considering a camera as inactive
	 * if no new data is received within the specified time frame.
	 * 
	 * Default value: 50
	 */
	public native double data_source_timeout(); public native SL_SynchronizationParameter data_source_timeout(double setter);

	/**
	 * \brief Determines whether to include the last data returned by a source in the final synchronized data.
	 *
	 * If the keep_last_data parameter is set to true and no data is present in the current synchronization window,
	 * the last data returned by the source will be included in the final synchronized data. This ensures continuity
	 * even in the absence of fresh data.
	 * 
	 * Default value: false
	 */
	public native @Cast("bool") boolean keep_last_data(); public native SL_SynchronizationParameter keep_last_data(boolean setter);

	/**
	 * \brief Maximum duration in milliseconds allowed for data to be considered as the last data.
	 *
	 * The maximum_lateness parameter sets the maximum duration within which data can be considered as the last
	 * available data. If the duration between the last received data and the current synchronization window exceeds
	 * this value, the data will not be included as the last data in the final synchronized output.
	 * 
	 * Default value: 50
	 */
	public native double maximum_lateness(); public native SL_SynchronizationParameter maximum_lateness(double setter);
}
