package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime; // above is all imports for ftc code

@TeleOp



public class ControllerTesting extends LinearOpMode {
    private Gyroscope imu;
    private ColorSensor test_color;
    private DcMotor test_motor;
    private Servo test_servo;
    private DigitalChannel test_touch;
    private DcMotor Wheel0, Wheel1, Arm, ArmResist; // Creates variables of DcMotor type (motors)
    private Servo Claw, Chopstick; // Creates variables of Servo Type
    private Boolean SlowDrive = false;  // for slowdrive
  
    @Override
    public void runOpMode() {
        
        Wheel0 = hardwareMap.get(DcMotor.class, "motor0"); // Set variables to motors and servos assigned in tablet driver app (configure robot)
        Wheel1 = hardwareMap.get(DcMotor.class, "motor1");
        Arm = hardwareMap.get(DcMotor.class, "arm");
        Chopstick = hardwareMap.get(Servo.class, "chopstick");
        Claw = hardwareMap.get(Servo.class, "claw");
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          Wheel1.setDirection(DcMotorSimple.Direction.REVERSE); // Reverse wheel
          Arm.setDirection(DcMotorSimple.Direction.FORWARD); // Set Arm Foward 
          Wheel0.setPower(0);
          Wheel1.setPower(0); // Set a neutral power to 0 to run while if statements not true
          
             if(gamepad1.left_stick_y < 0){
              fwdlm(); // Robot Left Wheel goes foward if left stick is up (above 0 for going forward)
            }
            if(gamepad1.right_stick_y < 0){
              fwdrm(); // R
            }
            
            if(gamepad1.right_stick_y > 0){
              bwdrm();
            
            }
            if(gamepad1.left_stick_y > 0){
              bwdlm();
            } 
            if(gamepad1.left_bumper){ // if statement changes variable if L1 is pressed by driver
                if(SlowDrive == false){
                    SlowDrive = true;
                }else{
                    SlowDrive = false;
                }
            } 
            
            
            if(gamepad2.left_stick_y == 0){
                Arm.setPower(0.1);
            } else if (gamepad2.left_stick_y < 0){ // For arm movement depending on left stick Y value
                     if(Chopstick.getPosition() == 0.5){
                        Arm.setPower(0.3);
                    }else{
                         Arm.setPower(0.60);
                    }
            }
            else if (gamepad2.left_stick_y > 0){
                     Arm.setPower(-0.20); 
                }   
             else { 
                     Arm.setPower(0); 
                } 
                
                if(gamepad2.a){ // open or close chopstick depending on position by pressing A button on gamepad 2 
                    if(Chopstick.getPosition() == 0.6){
                        Chopstick.setPosition(1);
                    }else{
                        Chopstick.setPosition(0.6);
                    }
        }
             telemetry.addData("Chopstick", Chopstick.getPosition()); // Output Chopstick Position
             telemetry.addData("Arm Test", Arm.getCurrentPosition()); // Output Arm Position
             telemetry.update();
            }
            
        }
        
        
    public void fwdrm(){ // Driving Functions below
      //Moving the right forward.
     if(SlowDrive == false){ // Will drive slower if SlowDrive is tru
         Wheel0.setPower(Math.abs(gamepad1.right_stick_y));
     }else{
         Wheel0.setPower(Math.abs(gamepad1.right_stick_y) / 3);
     }
    }
    
     public void fwdlm(){
      //Moving the left wheel forward.
      if(SlowDrive == false){
         Wheel1.setPower(Math.abs(gamepad1.left_stick_y));
     }else{
         Wheel1.setPower(Math.abs(gamepad1.left_stick_y) / 3);
     }
    }
    
     public void bwdrm(){
      //Moving the right wheel Backwards.
      if(SlowDrive == false){
         Wheel0.setPower(-Math.abs(gamepad1.right_stick_y));
     }else{
         Wheel0.setPower(-Math.abs(gamepad1.right_stick_y) / 3);
     }
    }
    
     public void bwdlm(){
      //Moving the left wheel Backwards.
      if(SlowDrive == false){
          Wheel1.setPower(-Math.abs(gamepad1.left_stick_y));
     }else{
         Wheel1.setPower(-Math.abs(gamepad1.left_stick_y) / 3);
     }
    }
    
    
    /*
    In order for this to turn left or right while moving forward, Controller
    is set to xright and yforward.
    
    Left Joystick is left motor forward/back
    Right Joystick is right moter forward/back
    */
    
}
