package us.ihmc.zed.library;

import us.ihmc.tools.nativelibraries.NativeLibraryDescription;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;
import us.ihmc.tools.nativelibraries.NativeLibraryWithDependencies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZEDJavaAPINativeLibrary implements NativeLibraryDescription {
    private static final int ZED_SDK_COMPATIBILITY_MAJOR_VERSION = 4;
    private static final int ZED_SDK_COMPATIBILITY_MINOR_VERSION = 2;

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
            archPackage = switch (os) {
                case WIN64, MACOSX64 -> throw new RuntimeException("Unsupported platform");
                case LINUX64 -> "linux-arm64";
            };
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
        String installedZEDSDKVersion = getZEDSDKCMakePackageVersion();

        int installedZEDSDKMajorVersion = 0;
        int installedZEDSDKMinorVersion = 0;

        if (installedZEDSDKVersion != null) {
            String[] installedZEDSDKVersionParts = installedZEDSDKVersion.split("\\.");

            try {
                installedZEDSDKMajorVersion = Integer.parseInt(installedZEDSDKVersionParts[0]);
                installedZEDSDKMinorVersion = Integer.parseInt(installedZEDSDKVersionParts[1]);
            } catch (NumberFormatException e) {
                // Ignore
            }
        }

        if (installedZEDSDKMajorVersion > ZED_SDK_COMPATIBILITY_MAJOR_VERSION ||
                (installedZEDSDKMajorVersion == ZED_SDK_COMPATIBILITY_MAJOR_VERSION && installedZEDSDKMinorVersion >= ZED_SDK_COMPATIBILITY_MINOR_VERSION)) {
            if (!loaded) {
                ZEDJavaAPINativeLibrary lib = new ZEDJavaAPINativeLibrary();
                loaded = NativeLibraryLoader.loadLibrary(lib);
            }
        } else {
            System.err.println("Incompatible ZED SDK installation ("
                    + installedZEDSDKVersion + ") found. Please install "
                    + ZED_SDK_COMPATIBILITY_MAJOR_VERSION + "." + ZED_SDK_COMPATIBILITY_MINOR_VERSION + " or higher.");
        }

        return loaded;
    }

    public static String getZEDSDKCMakePackageVersion() {
        String cmakePackageFilePath;

        if (System.getProperty("os.name").contains("Windows")) {
            cmakePackageFilePath = "C:/Program Files (x86)/ZED SDK/zed-config-version.cmake";
        } else {
            cmakePackageFilePath = "/usr/local/zed/zed-config-version.cmake";
        }

        File cmakePackageFile = new File(cmakePackageFilePath);

        if (cmakePackageFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(cmakePackageFile))) {
                String line;
                Pattern pattern = Pattern.compile("set\\(PACKAGE_VERSION \"(\\d+\\.\\d+\\.\\d+)\"\\)");

                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        return matcher.group(1).trim();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}