package us.ihmc.zed.library;

import us.ihmc.tools.nativelibraries.NativeLibraryDescription;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;
import us.ihmc.tools.nativelibraries.NativeLibraryWithDependencies;

public class ZEDJavaAPINativeLibrary implements NativeLibraryDescription {
    @Override
    public String getPackage(OperatingSystem os, Architecture arch) {
        String archPackage = "";
        if (arch == Architecture.x64) {
            archPackage = switch (os) {
                case WIN64 -> "windows-x86_64";
                case MACOSX64 -> throw new RuntimeException("Unsupported platform");
                case LINUX64 -> "linux-x86_64";
            };
        } else if (arch == Architecture.arm64) {
            throw new RuntimeException("Unsupported platform"); // TODO:
        }

        return "zed-java-api.native." + archPackage;
    }

    @Override
    public NativeLibraryWithDependencies getLibraryWithDependencies(OperatingSystem os, Architecture arch) {
        switch (os) {
            case LINUX64 -> {
                return NativeLibraryWithDependencies.fromFilename("libjnized.so", "libsl_zed_c.so");
            }
            case WIN64 -> {
                return NativeLibraryWithDependencies.fromFilename("jnized.dll", "sl_zed_c.dll");
            }
            case MACOSX64 -> throw new RuntimeException("Unsupported platform");
        }
        return null;
    }

    private static boolean loaded = false;

    public static boolean load() {
        if (!loaded) {
            ZEDJavaAPINativeLibrary lib = new ZEDJavaAPINativeLibrary();
            loaded = NativeLibraryLoader.loadLibrary(lib);
        }
        return loaded;
    }
}