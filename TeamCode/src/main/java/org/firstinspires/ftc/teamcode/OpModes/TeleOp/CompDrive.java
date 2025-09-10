package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import static org.firstinspires.ftc.teamcode.aProccedural.Components.leftFront;
import static org.firstinspires.ftc.teamcode.aProccedural.Components.leftLauncherMotor;
import static org.firstinspires.ftc.teamcode.aProccedural.Components.leftRear;
import static org.firstinspires.ftc.teamcode.aProccedural.Components.rightFront;
import static org.firstinspires.ftc.teamcode.aProccedural.Components.rightLauncherMotor;
import static org.firstinspires.ftc.teamcode.aProccedural.Components.rightRear;
import static org.firstinspires.ftc.teamcode.aProccedural.Constants.CONVEYOR_REVERSED;
import static org.firstinspires.ftc.teamcode.aProccedural.Constants.CONVEYOR_RUN;
import static org.firstinspires.ftc.teamcode.aProccedural.Constants.INTAKE_RUN;
import static org.firstinspires.ftc.teamcode.aProccedural.Constants.LAUNCHER_POWER;
import static org.firstinspires.ftc.teamcode.aProccedural.Constants.LAUNCHER_RUN;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.aProccedural.Components;
import org.firstinspires.ftc.teamcode.aProccedural.Constants;
import org.firstinspires.ftc.teamcode.aProccedural.Input;

public class CompDrive extends OpMode {

    //Instantiated new input
    Input input = new Input();


    @Override
    public void init() {
        //Initialize Components
        Components.initComponents(hardwareMap);


        /* ---------- Telemetry ---------- */
        telemetry.addLine("--------- Initialization Complete ---------");
    }

    @Override
    public void loop() {


        /* ---------- Launcher ---------- */
        if(input.a.down()){
            LAUNCHER_RUN =! LAUNCHER_RUN;
        }
        if(LAUNCHER_RUN){
            leftLauncherMotor.setPower(LAUNCHER_POWER);
            rightLauncherMotor.setPower(LAUNCHER_POWER);
        }

        /* ---------- Intake ---------- */
        if(input.b.down()){
            INTAKE_RUN =! INTAKE_RUN;
        }
        if(INTAKE_RUN){
            //todo this (need to design)
        }

        /* ---------- Conveyor ---------- */
        if(input.x.down()){
            CONVEYOR_RUN =! CONVEYOR_RUN;
        }
        if(input.y.down()){
            CONVEYOR_REVERSED =! CONVEYOR_REVERSED;
        }
        if(CONVEYOR_RUN){
            //todo this (need to design)
            if(CONVEYOR_REVERSED){

            }
        }


        /* ---------- Drivetrain ---------- */

        //Drivetrain movement values
        double forward = gamepad1.left_stick_y;
        double strafes = gamepad1.left_stick_x;
        double rotates = gamepad1.right_stick_x;

        //Setting Powers
        leftFront.setPower(forward + strafes + rotates);
        rightFront.setPower(forward - strafes - rotates);
        leftRear.setPower(forward - strafes + rotates);
        rightRear.setPower(forward + strafes - rotates);

        /* ---------- Telemetry ---------- */
        telemetry.addLine("--------- Comp Drive Running ---------");
        telemetry.addLine("Intake running status: " + INTAKE_RUN);
        telemetry.addLine("Conveyor running status: " + CONVEYOR_RUN);
        telemetry.addLine("Launcher running status: " + LAUNCHER_RUN);
    }

}
