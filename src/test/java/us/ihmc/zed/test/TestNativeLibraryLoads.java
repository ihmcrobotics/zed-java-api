package us.ihmc.zed.test;

import org.junit.jupiter.api.Test;
import us.ihmc.zed.global.zed;
import us.ihmc.zed.library.ZEDJavaAPINativeLibrary;

public class TestNativeLibraryLoads
{
   @Test
   public void testLoadingZEDNativeLibrary()
   {
      ZEDJavaAPINativeLibrary.load();

      System.out.println("ZED SDK version: " + zed.sl_get_sdk_version().getString());
   }
}
