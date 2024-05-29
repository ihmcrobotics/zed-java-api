package us.ihmc.zed;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(value = {
      @Platform(
            includepath = {"include", "/usr/local/cuda/include"},
            include = {"types_c.h", "zed_interface.h"},
            linkpath = {"lib"},
            link = "sl_zed_c",
            preload = "jnized"
      )
},
      target = "us.ihmc.zed",
      global = "us.ihmc.zed.global.zed"
)
public class ZEDJavaAPIConfig implements InfoMapper
{
   @Override
   public void map(InfoMap infoMap)
   {
      // TODO: Fix CUDA
//      infoMap.put(new Info("CUcontext").pointerTypes("org.bytedeco.cuda.cudart.CUctx_st"));
//      infoMap.put(new Info("cudaStream_t").pointerTypes("org.bytedeco.cuda.cudart.CUstream_st"));
      infoMap.put(new Info("CUcontext").skip());
      infoMap.put(new Info("cudaStream_t").skip());
   }
}