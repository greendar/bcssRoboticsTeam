


public void controller(){
  float d0x = -0.5;
  float d0y = 0.866;
  float d1x = 0.5;
  float d1y = 0.866;
  float d2x = 1;
  float d2y = 0;
  int gpx = gamepad1.left_joystick_x;
  int gpy = gamepad1.left_joystick_y;
  motor0.SetPower(d0x * gpx + d0y * gpy)
  motor1.SetPower(d1x * gpx + d1y * gpy)
  motor2.SetPower(d2x * gpx + d2y * gpy)
}
