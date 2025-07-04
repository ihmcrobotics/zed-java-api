///////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2024, STEREOLABS.
//
// All rights reserved.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//
///////////////////////////////////////////////////////////////////////////

package us.ihmc.zed.test;

import org.bytedeco.javacpp.Pointer;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.opencv_core.Mat;
import us.ihmc.zed.SL_InitParameters;
import us.ihmc.zed.SL_RuntimeParameters;
import us.ihmc.zed.library.ZEDJavaAPINativeLibrary;

import static us.ihmc.zed.global.zed.*;

public class DemoImageCaptureOpenCV {
    private static volatile boolean running = true;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> running = false));
    }

    public static void main(String[] args) {
        ZEDJavaAPINativeLibrary.load();

        int camera_id = 0;
        sl_create_camera(camera_id);

        SL_InitParameters init_param = new SL_InitParameters();
        init_param.camera_fps(60);
        init_param.resolution(SL_RESOLUTION_HD720);
        init_param.input_type(SL_INPUT_TYPE_USB);
        init_param.camera_device_id(camera_id);
        init_param.camera_image_flip(SL_FLIP_MODE_AUTO);
        init_param.camera_disable_self_calib(false);
        init_param.enable_image_enhancement(true);
        init_param.svo_real_time_mode(true);
        init_param.depth_mode(SL_DEPTH_MODE_PERFORMANCE);
        init_param.depth_stabilization(1);
        init_param.depth_maximum_distance(40);
        init_param.depth_maximum_distance(-1);
        init_param.coordinate_unit(SL_UNIT_METER);
        init_param.coordinate_system(SL_COORDINATE_SYSTEM_LEFT_HANDED_Y_UP);
        init_param.sdk_gpu_id(-1);
        init_param.sdk_verbose(0);
        init_param.sensors_required(false);
        init_param.enable_right_side_measure(false);
        init_param.open_timeout_sec(5.0f);
        init_param.async_grab_camera_recovery(false);
        init_param.grab_compute_capping_fps(0);
        init_param.enable_image_validity_check(false);

        // Open the camera
        int state = sl_open_camera(camera_id, init_param, 0, "", "", 0, "", "", "");

        if (state != 0) {
            throw new RuntimeException("Could not initialize ZED");
        }

        SL_RuntimeParameters rt_param = new SL_RuntimeParameters();
        rt_param.enable_depth(true);
        rt_param.confidence_threshold(95);
        rt_param.reference_frame(SL_REFERENCE_FRAME_CAMERA);
        rt_param.texture_confidence_threshold(100);
        rt_param.remove_saturated_areas(true);

        int width = sl_get_width(camera_id);
        int height = sl_get_height(camera_id);

        // Create image ptr.
        Pointer image_ptr;
        // Init pointer.
        image_ptr = sl_mat_create_new(width, height, SL_MAT_TYPE_U8_C4, SL_MEM_CPU);

        Thread imageGrabThread = new Thread(() ->
        {
            while (running) {
                // Grab an image
                int grabState = sl_grab(camera_id, rt_param);
                // A new image is available if grab() returns ERROR_CODE::SUCCESS
                if (grabState == 0) {
                    // Get the left image
                    sl_retrieve_image(camera_id, image_ptr, SL_VIEW_LEFT, SL_MEM_CPU, width, height, null);
                    // Display the image resolution and its acquisition timestamp
                    System.out.printf("Image resolution: %d x %d || %d\n", width, height, sl_get_current_timestamp(camera_id));
                }
            }
        }, "ImageGrabThread");
        imageGrabThread.start();

        while (running) {
            Mat imageMat = new Mat(height,
                    width,
                    opencv_core.CV_8UC4,
                    sl_mat_get_ptr(image_ptr, SL_MEM_CPU),
                    sl_mat_get_step_bytes(image_ptr, SL_MEM_CPU));

            opencv_highgui.imshow("Left", imageMat);

            opencv_highgui.waitKey(1);

            imageMat.close();
        }

        sl_close_camera(camera_id);
    }
}
