


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
/*
class Vec:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"[{self.x}, {self.y}]"

    def dot(self, other):
        return self.x * other.x + self.y * other.y

def motorSpeed(heading):
    return heading.dot(D1), heading.dot(D2), heading.dot(D3)

def setTirePosition():
    global D1, D2, D3
    D1 = Vec(-0.5, round((3**0.5)/2, 3))
    D2 = Vec(0.5, round((3**0.5)/2, 3))
    D3 = Vec(1, 0)

setTirePosition()

H1 = Vec(60, 20)

print(motorSpeed(H1))
*/
