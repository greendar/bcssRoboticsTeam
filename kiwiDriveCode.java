


public void controller(){
  double d0x = -0.5;
  double d0y = 0.866;
  double d1x = 0.5;
  double d1y = 0.866;
  double d2x = 1;
  double d2y = 0;
  float gpx = gamepad1.left_stick_x;
  float gpy = gamepad1.left_stick_y;
  motor0.setPower(d0x * gpx + d0y * gpy)
  motor1.setPower(d1x * gpx + d1y * gpy)
  motor2.setPower(d2x * gpx + d2y * gpy)
}
