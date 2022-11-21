package TRJavaHWs.lesson14;

public class LessonDemo {
    public static void main(String[] args) {
        LessonDemo m = new LessonDemo();
        m.testButtons();


    }

    private void testButtons() {
        LessonButton b = new LessonButton();
        b.click(() -> System.out.println("Action"));
        b.click(new  MyButtonAction() :: performAction);

        LessonButtonAction lba = new LessonButtonAction() {
            @Override
            public void performAction() {
                System.out.println("Click");
            }
        };

        b.click(lba::performAction);
    }


    class MyButtonAction implements LessonButtonAction {

        @Override
        public void performAction() {
            System.out.println("Action 2");
        }
    }
}
