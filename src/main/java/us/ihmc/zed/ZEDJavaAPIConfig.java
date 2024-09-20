package us.ihmc.zed;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(value = {
        @Platform(
                include = {"types_c.h", "zed_interface.h"},
                linkpath = "lib",
                link = "sl_zed_c",
                preload = "jnized"
        ),
        @Platform(
                value = "linux",
                includepath = {"include", "/usr/local/cuda/include"}
        ),
        @Platform(
                value = "windows",
                // This CUDA includepath is where CUDA would be installed within a Windows GitHub runner that compiles the native binaries
                includepath = {"include", "C:\\\\Program Files\\\\NVIDIA GPU Computing Toolkit\\\\CUDA\\\\v11.8\\\\include"}
        )
},
        target = "us.ihmc.zed",
        global = "us.ihmc.zed.global.zed"
)
public class ZEDJavaAPIConfig implements InfoMapper {
    @Override
    public void map(InfoMap infoMap) {
        infoMap.put(new Info().javaText("import org.bytedeco.cuda.cudart.CUctx_st;"))
               .put(new Info().javaText("import org.bytedeco.cuda.cudart.CUstream_st;"))
               .put(new Info("CUcontext").valueTypes("CUctx_st").pointerTypes("@ByPtrPtr CUctx_st"))
               .put(new Info("CUstream").valueTypes("CUstream_st").pointerTypes("@ByPtrPtr CUstream_st"))
               .put(new Info("cudaStream_t").valueTypes("CUstream_st").pointerTypes("@ByPtrPtr CUstream_st"));
    }
}