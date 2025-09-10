package org.firstinspires.ftc.teamcode.OpModes.Prototypes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LauncherTesting extends OpMode {

    //left
    private DcMotor l;
    //right
    private DcMotor r;
    //power
    private double p;
    @Override
    public void init() {
        l = hardwareMap.get(DcMotor.class, "left");
        l.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r = hardwareMap.get(DcMotor.class, "right");
        r.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void loop() {

        //run
        if(gamepad1.a){
            l.setPower(p);
            r.setPower(p);
        } else {
            l.setPower(0);
            r.setPower(0);
        }

        //change power
        if(gamepad1.x){
            p += 0.05;
        }
        if(gamepad1.y){
            p -= 0.05;
        }

        //Reverse
        if(gamepad1.b && l.getPower() == 0 ){
            if(l.getDirection() == DcMotorSimple.Direction.REVERSE){
                l.setDirection(DcMotorSimple.Direction.FORWARD);
                r.setDirection(DcMotorSimple.Direction.FORWARD);
            } else {
                l.setDirection(DcMotorSimple.Direction.REVERSE);
                r.setDirection(DcMotorSimple.Direction.REVERSE);
            }
        }

    }
}
