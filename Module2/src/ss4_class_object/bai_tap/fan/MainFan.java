package ss4_class_object.bai_tap.fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setOn(true);
        fan1.setColor("Yellow");
        fan1.setRadius(10);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setOn(false);
        fan2.setColor("Blue");
        fan2.setRadius(5);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
