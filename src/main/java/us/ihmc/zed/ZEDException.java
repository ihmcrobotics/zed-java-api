package us.ihmc.zed;

public class ZEDException extends Exception
{
   private final int zedErrorCode;

   public ZEDException(int zedErrorCode)
   {
      this.zedErrorCode = zedErrorCode;
   }

   @Override
   public String getMessage()
   {
      return ZEDTools.errorMessage(zedErrorCode);
   }
}
