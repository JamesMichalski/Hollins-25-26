package org.firstinspires.ftc.teamcode.aProccedural;



import static org.firstinspires.ftc.teamcode.aProccedural.Constants.PIVOT_HORIZONTAL_POS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * File to store all hardware code
 */
public class Components {

    //Instantiate Drive Motors
    public static DcMotor leftFront;
    public static DcMotor rightFront;
    public static DcMotor leftRear;
    public static DcMotor rightRear;

    //Instantiate Launcher Motors
    public static DcMotor leftLauncherMotor;
    public static DcMotor rightLauncherMotor;

    //Instantiate Pivot Motors
    public static DcMotorEx pivotMotor;


    /*
        Method to initialize components
        param hardwareMap is hardwareMap
     */
    public static void initComponents(HardwareMap hardwareMap){

        //Initialize Drive Motors
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");

        //Drive Motor Settings
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Initialize Launcher
        leftLauncherMotor = hardwareMap.get(DcMotor.class, "leftLauncherMotor");
        rightLauncherMotor = hardwareMap.get(DcMotor.class, "rightLauncherMotor");

        //Launcher Settings
        leftLauncherMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightLauncherMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Initialize Pivot Motor
        pivotMotor = hardwareMap.get(DcMotorEx.class, "pivotMotor");
        pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivotMotor.setTargetPosition(PIVOT_HORIZONTAL_POS);

    }


}
